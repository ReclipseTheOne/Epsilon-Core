package epsilon.common.machines.qol;

import gregtech.api.capability.IEnergyContainer;
import gregtech.api.capability.impl.RecipeLogicEnergy;
import gregtech.api.metatileentity.SimpleMachineMetaTileEntity;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.api.recipes.Recipe;
import gregtech.api.recipes.RecipeMap;
import gregtech.client.renderer.ICubeRenderer;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.*;
import net.minecraftforge.items.IItemHandlerModifiable;
import epsilon.api.util.EPLogger;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class MetaTileEntityEnchantDuplicator extends SimpleMachineMetaTileEntity {

    private NBTTagCompound currentEnchants;

    public MetaTileEntityEnchantDuplicator(ResourceLocation metaTileEntityId, RecipeMap<?> recipeMap, ICubeRenderer renderer, int tier) {
        super(metaTileEntityId, recipeMap, renderer, tier, true);
    }

    @Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity iGregTechTileEntity) {
        return new MetaTileEntityEnchantDuplicator(this.metaTileEntityId, this.workable.getRecipeMap(), this.renderer, this.getTier()   );
    }


    protected RecipeLogicEnergy createWorkable(RecipeMap<?> recipeMap) {
        return new RecipeLogicDuplicator(this, recipeMap, () -> this.energyContainer);
    }

    public class RecipeLogicDuplicator extends RecipeLogicEnergy {
        public RecipeLogicDuplicator(MetaTileEntity tileEntity, RecipeMap<?> recipeMap, Supplier<IEnergyContainer> energyContainer) {
            super(tileEntity, recipeMap, energyContainer);
        }

        @Override
        protected void setupRecipe(Recipe recipe) {
            currentEnchants = getEnchantmentTagFromCircuit();
            ItemStack currentCircuit = getEnchantedCircuit();
            int count = currentCircuit.getCount();
            super.setupRecipe(recipe);
            currentCircuit.setCount(1);
            getImportItems().setStackInSlot(0, currentCircuit);
        }

        @Override
        protected void completeRecipe() {
            super.completeRecipe();
            IItemHandlerModifiable exportInventory = metaTileEntity.getExportItems();
            IItemHandlerModifiable importInventory = metaTileEntity.getImportItems();

            ItemStack newBook = exportInventory.getStackInSlot(0);

            if (currentEnchants != null) {
                newBook.setTagCompound(currentEnchants);
            } else {
                newBook.shrink(1);
            }

        }

        // WE LOVE COPY & PASTING!!! -Message approved by Reclipse and Super
        protected NBTTagCompound getEnchantmentTagFromCircuit() {
            IItemHandlerModifiable importInventory = metaTileEntity.getImportItems();
            for (int i = 0; i < importInventory.getSlots(); i++) {
                ItemStack stack = importInventory.getStackInSlot(i);
                NBTTagCompound compound = stack.getTagCompound();
                if (compound != null && (!compound.getTagList("StoredEnchantments", 10).isEmpty())) {
                    return compound;
                }
            }
            return null;
        }

        protected ItemStack getEnchantedCircuit() {
            IItemHandlerModifiable importInventory = metaTileEntity.getImportItems();
            return importInventory.getStackInSlot(0);

        }

    }
}
