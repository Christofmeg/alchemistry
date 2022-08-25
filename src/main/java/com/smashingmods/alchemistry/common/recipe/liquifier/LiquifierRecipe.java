package com.smashingmods.alchemistry.common.recipe.liquifier;

import com.smashingmods.alchemistry.common.recipe.AbstractAlchemistryRecipe;
import com.smashingmods.alchemistry.registry.RecipeRegistry;
import com.smashingmods.alchemylib.common.item.IngredientStack;
import net.minecraft.core.NonNullList;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import net.minecraftforge.fluids.FluidStack;

public class LiquifierRecipe extends AbstractAlchemistryRecipe {

    private final IngredientStack input;
    private final FluidStack output;

    public LiquifierRecipe(ResourceLocation pId, String pGroup, IngredientStack pInput, FluidStack pOutput) {
        super(pId, pGroup);
        this.input = pInput;
        this.output = pOutput;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return RecipeRegistry.LIQUIFIER_SERIALIZER.get();
    }

    @Override
    public RecipeType<?> getType() {
        return RecipeRegistry.LIQUIFIER_TYPE;
    }

    @Override
    public boolean matches(Inventory pContainer, Level pLevel) {
        return false;
    }

    @Override
    public NonNullList<Ingredient> getIngredients() {
        return NonNullList.of(input.getIngredient());
    }

    @Override
    public String toString(){
        return String.format("input=%s, outputs=%s", input, output);
    }

    public IngredientStack getInput() {
        return input;
    }

    public FluidStack getOutput() {
        return output;
    }
}