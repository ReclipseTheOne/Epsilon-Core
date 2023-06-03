package epsilon.common.recipe.qol;

import gregtech.api.recipes.ingredients.nbtmatch.NBTCondition;
import gregtech.api.recipes.ingredients.nbtmatch.NBTMatcher;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

import static epsilon.common.recipe.EPRecipeMaps.*;
import static epsilon.common.item.EPMetaItem.*;
import static gregtech.common.items.MetaItems.INTEGRATED_CIRCUIT;

public class Enchantments {

    public static void init() {
        ENCHANT_DUPLICATING_RECIPES.recipeBuilder().EUt(512).duration(1000)
                .inputNBT(ENCHANTED_CIRCUIT, NBTMatcher.ANY, NBTCondition.ANY)
                .outputs(new ItemStack(Items.ENCHANTED_BOOK))
                .buildAndRegister();

        ENCHANT_PROGRAMMING_RECIPES.recipeBuilder().EUt(128).duration(600)
                .inputNBT(INTEGRATED_CIRCUIT, NBTMatcher.ANY, NBTCondition.ANY)
                .inputNBT("bookEnchanted", NBTMatcher.ANY, NBTCondition.ANY)
                .outputs(ENCHANTED_CIRCUIT.getStackForm(1))
                .buildAndRegister();
    }
}
