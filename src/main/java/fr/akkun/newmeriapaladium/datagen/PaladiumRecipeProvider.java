package fr.akkun.newmeriapaladium.datagen;

import fr.akkun.newmeriapaladium.NewmeriaPaladium;
import fr.akkun.newmeriapaladium.PaladiumBlocks;
import fr.akkun.newmeriapaladium.PaladiumItems;
import net.minecraft.advancements.Advancement;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.CookingBookCategory;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;

/** The recipes of the old Newmeria Mod: tools with sticks, like vanilla. */
public class PaladiumRecipeProvider extends RecipeProvider {
    public PaladiumRecipeProvider(BootstrapContext<Recipe<?>> recipeOutput, BootstrapContext<Advancement> advancementOutput) {
        super(recipeOutput, advancementOutput);
    }

    @Override
    protected void buildRecipes() {
        Item ingot = PaladiumItems.PALADIUM_INGOT.get();

        SimpleCookingRecipeBuilder.smelting(Ingredient.of(PaladiumBlocks.PALADIUM_ORE.get()), RecipeCategory.MISC, CookingBookCategory.MISC, ingot, 2.0F, 200)
                .unlockedBy(getHasName(PaladiumBlocks.PALADIUM_ORE.get()), has(PaladiumBlocks.PALADIUM_ORE.get()))
                .save(output);
        SimpleCookingRecipeBuilder.blasting(Ingredient.of(PaladiumBlocks.PALADIUM_ORE.get()), RecipeCategory.MISC, CookingBookCategory.MISC, ingot, 2.0F, 100)
                .unlockedBy(getHasName(PaladiumBlocks.PALADIUM_ORE.get()), has(PaladiumBlocks.PALADIUM_ORE.get()))
                .save(output, NewmeriaPaladium.MOD_ID + ":" + getItemName(ingot) + "_from_blasting");

        shaped(RecipeCategory.BUILDING_BLOCKS, PaladiumBlocks.PALADIUM_BLOCK.get())
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', ingot)
                .unlockedBy(getHasName(ingot), has(ingot))
                .save(output);
        shapeless(RecipeCategory.MISC, ingot, 9)
                .requires(PaladiumBlocks.PALADIUM_BLOCK.get())
                .unlockedBy(getHasName(PaladiumBlocks.PALADIUM_BLOCK.get()), has(PaladiumBlocks.PALADIUM_BLOCK.get()))
                .save(output, NewmeriaPaladium.MOD_ID + ":" + getItemName(ingot) + "_from_paladium_block");

        tool(RecipeCategory.COMBAT, PaladiumItems.PALADIUM_SWORD.get(), "#", "#", "X");
        tool(RecipeCategory.TOOLS, PaladiumItems.PALADIUM_PICKAXE.get(), "###", " X ", " X ");
        tool(RecipeCategory.TOOLS, PaladiumItems.PALADIUM_SHOVEL.get(), "#", "X", "X");
        tool(RecipeCategory.TOOLS, PaladiumItems.PALADIUM_AXE.get(), "##", "#X", " X");
        tool(RecipeCategory.TOOLS, PaladiumItems.PALADIUM_HOE.get(), "##", " X", " X");
        tool(RecipeCategory.TOOLS, PaladiumItems.PALADIUM_HAMMER.get(), "###", "#X#", " X ");

        armor(PaladiumItems.PALADIUM_HELMET.get(), "###", "# #");
        armor(PaladiumItems.PALADIUM_CHESTPLATE.get(), "# #", "###", "###");
        armor(PaladiumItems.PALADIUM_LEGGINGS.get(), "###", "# #", "# #");
        armor(PaladiumItems.PALADIUM_BOOTS.get(), "# #", "# #");
    }

    /** '#' is a Paladium Ingot, 'X' a stick. */
    private void tool(RecipeCategory category, Item result, String... pattern) {
        var builder = shaped(category, result);
        for (String row : pattern) {
            builder.pattern(row);
        }
        builder.define('#', PaladiumItems.PALADIUM_INGOT.get())
                .define('X', Items.STICK)
                .unlockedBy(getHasName(PaladiumItems.PALADIUM_INGOT.get()), has(PaladiumItems.PALADIUM_INGOT.get()))
                .save(output);
    }

    /** '#' is a Paladium Ingot. */
    private void armor(Item result, String... pattern) {
        var builder = shaped(RecipeCategory.COMBAT, result);
        for (String row : pattern) {
            builder.pattern(row);
        }
        builder.define('#', PaladiumItems.PALADIUM_INGOT.get())
                .unlockedBy(getHasName(PaladiumItems.PALADIUM_INGOT.get()), has(PaladiumItems.PALADIUM_INGOT.get()))
                .save(output);
    }
}
