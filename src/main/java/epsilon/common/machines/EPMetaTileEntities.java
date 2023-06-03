package epsilon.common.machines;

import epsilon.common.machines.qol.MetaTileEntityEnchantProgrammer;
import gregtech.api.GTValues;
import gregtech.client.renderer.texture.Textures;
import epsilon.common.machines.qol.MetaTileEntityEnchantDuplicator;
import epsilon.common.recipe.EPRecipeMaps;
import net.minecraft.util.ResourceLocation;

import static gregtech.common.metatileentities.MetaTileEntities.*;

public class EPMetaTileEntities {
    public static MetaTileEntityEnchantDuplicator[] ENCHANT_DUPLICATOR = new MetaTileEntityEnchantDuplicator[GTValues.V.length - 1];
    public static MetaTileEntityEnchantProgrammer[] ENCHANT_PROGRAMMER = new MetaTileEntityEnchantProgrammer[GTValues.V.length - 1];

    public static void init() {
        ENCHANT_DUPLICATOR[1] = registerMetaTileEntity(15032, new MetaTileEntityEnchantDuplicator(epsilonId("enchant_duplicator.hv"), EPRecipeMaps.ENCHANT_DUPLICATING_RECIPES, Textures.REPLICATOR_OVERLAY, 3));
        ENCHANT_DUPLICATOR[2] = registerMetaTileEntity(15033, new MetaTileEntityEnchantDuplicator(epsilonId("enchant_duplicator.ev"), EPRecipeMaps.ENCHANT_DUPLICATING_RECIPES, Textures.REPLICATOR_OVERLAY, 4));
        ENCHANT_DUPLICATOR[3] = registerMetaTileEntity(15034, new MetaTileEntityEnchantDuplicator(epsilonId("enchant_duplicator.iv"), EPRecipeMaps.ENCHANT_DUPLICATING_RECIPES, Textures.REPLICATOR_OVERLAY, 5));
        if (getMidTier("enchant_duplicator")) {
            ENCHANT_DUPLICATOR[4] = registerMetaTileEntity(15035, new MetaTileEntityEnchantDuplicator(epsilonId("enchant_duplicator.luv"), EPRecipeMaps.ENCHANT_DUPLICATING_RECIPES, Textures.REPLICATOR_OVERLAY, 6));
            ENCHANT_DUPLICATOR[5] = registerMetaTileEntity(15036, new MetaTileEntityEnchantDuplicator(epsilonId("enchant_duplicator.zpm"), EPRecipeMaps.ENCHANT_DUPLICATING_RECIPES, Textures.REPLICATOR_OVERLAY, 7));
            ENCHANT_DUPLICATOR[6] = registerMetaTileEntity(15037, new MetaTileEntityEnchantDuplicator(epsilonId("enchant_duplicator.uv"), EPRecipeMaps.ENCHANT_DUPLICATING_RECIPES, Textures.REPLICATOR_OVERLAY, 8));
        }

        ENCHANT_PROGRAMMER[1] = registerMetaTileEntity(15038, new MetaTileEntityEnchantProgrammer(epsilonId("enchant_programmer.hv"), EPRecipeMaps.ENCHANT_PROGRAMMING_RECIPES, Textures.REPLICATOR_OVERLAY, 3));
        ENCHANT_PROGRAMMER[2] = registerMetaTileEntity(15039, new MetaTileEntityEnchantProgrammer(epsilonId("enchant_programmer.ev"), EPRecipeMaps.ENCHANT_PROGRAMMING_RECIPES, Textures.REPLICATOR_OVERLAY, 4));
        ENCHANT_PROGRAMMER[3] = registerMetaTileEntity(15040, new MetaTileEntityEnchantProgrammer(epsilonId("enchant_programmer.iv"), EPRecipeMaps.ENCHANT_PROGRAMMING_RECIPES, Textures.REPLICATOR_OVERLAY, 5));
        if (getMidTier("enchant_programmer")) {
            ENCHANT_PROGRAMMER[4] = registerMetaTileEntity(15041, new MetaTileEntityEnchantProgrammer(epsilonId("enchant_programmer.luv"), EPRecipeMaps.ENCHANT_PROGRAMMING_RECIPES, Textures.REPLICATOR_OVERLAY, 6));
            ENCHANT_PROGRAMMER[5] = registerMetaTileEntity(15042, new MetaTileEntityEnchantProgrammer(epsilonId("enchant_programmer.zpm"), EPRecipeMaps.ENCHANT_PROGRAMMING_RECIPES, Textures.REPLICATOR_OVERLAY, 7));
            ENCHANT_PROGRAMMER[6] = registerMetaTileEntity(15043, new MetaTileEntityEnchantProgrammer(epsilonId("enchant_programmer.uv"), EPRecipeMaps.ENCHANT_PROGRAMMING_RECIPES, Textures.REPLICATOR_OVERLAY, 8));
        }
    }

    private static ResourceLocation epsilonId(String name) {
        return new ResourceLocation("epsilon", name);
    }
}
