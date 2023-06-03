package epsilon.common.machines.qol;

import epsilon.api.util.EPLogger;
import gregtech.api.capability.IEnergyContainer;
import gregtech.api.capability.impl.RecipeLogicEnergy;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.SimpleMachineMetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.api.recipes.Recipe;
import gregtech.api.recipes.RecipeMap;
import gregtech.client.renderer.ICubeRenderer;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.items.IItemHandlerModifiable;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class MetaTileEntityEnchantProgrammer extends SimpleMachineMetaTileEntity {

    private NBTTagCompound currentEnchants;
    public MetaTileEntityEnchantProgrammer(ResourceLocation metaTileEntityId, RecipeMap<?> recipeMap, ICubeRenderer renderer, int tier) {
        super(metaTileEntityId, recipeMap, renderer, tier, true);
    }

    @Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity iGregTechTileEntity) {
        return new MetaTileEntityEnchantProgrammer(this.metaTileEntityId, this.workable.getRecipeMap(), this.renderer, this.getTier()   );
    }


    protected RecipeLogicEnergy createWorkable(RecipeMap<?> recipeMap) {
        return new RecipeLogicProgrammer(this, recipeMap, () -> this.energyContainer);
    }

    public class RecipeLogicProgrammer extends RecipeLogicEnergy {
        public RecipeLogicProgrammer(MetaTileEntity tileEntity, RecipeMap<?> recipeMap, Supplier<IEnergyContainer> energyContainer) {
            super(tileEntity, recipeMap, energyContainer);
        }

        @Override
        protected void setupRecipe(Recipe recipe) {
            currentEnchants = getEnchantmentTagFromBook();
            super.setupRecipe(recipe);
        }

        @Override
        protected void completeRecipe() {
            super.completeRecipe();
            IItemHandlerModifiable exportInventory = metaTileEntity.getExportItems();
            ItemStack newCircuit = exportInventory.getStackInSlot(0);

            if (currentEnchants != null) {
                newCircuit.setTagCompound(currentEnchants);
            } else {
                newCircuit.shrink(1);
            }
        }

        protected NBTTagCompound getEnchantmentTagFromBook() {
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

    }
}
