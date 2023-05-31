//UNCOMMENT AFTER TESTING IS FINISHED
/*package nottoogreggy.common.mte.qol;

import gregtech.api.capability.IActiveOutputSide;
import gregtech.api.capability.IControllable;
import gregtech.api.metatileentity.TieredMetaTileEntity;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.api.gui.ModularUI;
import net.minecraft.entity.player.EntityPlayer;
import gregtech.api.gui.GuiTextures;

import net.minecraft.util.*;

public class MetaTileEntityEnchantDuplicator extends TieredMetaTileEntity implements IControllable, IActiveOutputSide {

    private boolean isWorking;
    private boolean isWorkingEnabled = true;

    private static final int BASE_EU_CONSUMPTION = 16;

    public MetaTileEntityEnchantDuplicator(ResourceLocation metaTileEntityId, int tier) {
        super(metaTileEntityId, tier);
        this.initializeInventory();
    }

    @Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity iGregTechTileEntity) {
        return new MetaTileEntityEnchantDuplicator(metaTileEntityId, getTier());
    }

    @Override
    public void update() {
        super.update();
        boolean isWorkingNow = energyContainer.getEnergyStored() >= getEnergy
    }

    protected int getEnergyConsumedPerTick() {
        return BASE_EU_CONSUMPTION * (1 << ((getTier() - 1) * 2));
    }

    @Override
    protected ModularUI createUI(EntityPlayer entityPlayer) {
        ModularUI.Builder builder = ModularUI.builder(GuiTextures.BACKGROUND, 176, 166)
    }
}
*/
