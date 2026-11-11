package fr.akkun.newmeriapaladium;

import net.minecraft.core.Holder;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingEquipmentChangeEvent;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;

/**
 * The effects of the Paladium armor, as on the Paladium server (Java):
 * <ul>
 *   <li>helmet: Night Vision II;</li>
 *   <li>boots: Speed I;</li>
 *   <li>chestplate and leggings: none.</li>
 * </ul>
 * Each piece gives its effect on its own, no full set needed. The effects are renewed every second while
 * the piece is worn, and taken away as soon as it is removed.
 */
@EventBusSubscriber(modid = NewmeriaPaladium.MOD_ID)
public class PaladiumArmorEffects {
    private static final int REFRESH_INTERVAL = 20;

    private record ArmorEffect(EquipmentSlot slot, Holder<MobEffect> effect, int amplifier, int duration) {
        /** Ambient and without particles, like a beacon effect: the icon stays but the player isn't covered in swirls. */
        MobEffectInstance create() {
            return new MobEffectInstance(effect, duration, amplifier, true, false, true);
        }

        /** True if the effect the entity has is ours (not a potion or a beacon one), so it can be taken away. */
        boolean isOurs(MobEffectInstance instance) {
            return instance.isAmbient() && instance.getAmplifier() == amplifier && instance.getDuration() <= duration;
        }
    }

    // Night Vision starts flickering under 10 seconds left: it is given 15 seconds, renewed every second.
    private static final ArmorEffect HELMET = new ArmorEffect(EquipmentSlot.HEAD, MobEffects.NIGHT_VISION, 1, 300);
    private static final ArmorEffect BOOTS = new ArmorEffect(EquipmentSlot.FEET, MobEffects.SPEED, 0, 40);

    @SubscribeEvent
    static void onPlayerTick(PlayerTickEvent.Post event) {
        if (!(event.getEntity() instanceof ServerPlayer player) || player.tickCount % REFRESH_INTERVAL != 0) {
            return;
        }
        apply(player, HELMET, PaladiumItems.PALADIUM_HELMET.get());
        apply(player, BOOTS, PaladiumItems.PALADIUM_BOOTS.get());
    }

    private static void apply(ServerPlayer player, ArmorEffect armorEffect, Item piece) {
        if (player.getItemBySlot(armorEffect.slot()).is(piece)) {
            player.addEffect(armorEffect.create());
        }
    }

    @SubscribeEvent
    static void onEquipmentChange(LivingEquipmentChangeEvent event) {
        LivingEntity entity = event.getEntity();
        if (entity.level().isClientSide()) {
            return;
        }
        removeIfTakenOff(event, entity, HELMET, PaladiumItems.PALADIUM_HELMET.get());
        removeIfTakenOff(event, entity, BOOTS, PaladiumItems.PALADIUM_BOOTS.get());
    }

    private static void removeIfTakenOff(LivingEquipmentChangeEvent event, LivingEntity entity, ArmorEffect armorEffect, Item piece) {
        if (event.getSlot() != armorEffect.slot() || !event.getFrom().is(piece) || event.getTo().is(piece)) {
            return;
        }
        MobEffectInstance current = entity.getEffect(armorEffect.effect());
        if (current != null && armorEffect.isOurs(current)) {
            entity.removeEffect(armorEffect.effect());
        }
    }
}
