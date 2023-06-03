package epsilon.common.item;

import gregtech.api.items.metaitem.MetaItem;
import gregtech.api.items.metaitem.StandardMetaItem;
import gregtech.api.items.metaitem.stats.IItemContainerItemProvider;
import gregtech.common.items.MetaItems;

import static gregtech.api.unification.material.Materials.*;

public class EPMetaItem extends StandardMetaItem {
    public EPMetaItem() {
    }

    public static MetaItem<?>.MetaValueItem ENCHANTED_CIRCUIT;

    @Override
    public void registerSubItems() {
        IItemContainerItemProvider selfContainerItemProvider = itemStack -> itemStack;

        ENCHANTED_CIRCUIT = addItem(1, "qol/enchanted_circuit");


    }

}
