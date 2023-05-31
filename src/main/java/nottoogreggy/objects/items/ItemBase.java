/*package nottoogreggy.objects.items;


import net.minecraft.item.Item;
import nottoogreggy.interfaces.IHasModel;
import nottoogreggy.NotTooGreggy;
import nottoogreggy.init.InitItems;

public class ItemBase extends Item implements IHasModel {
    public ItemBase(String name) {
        setTranslationKey(name);
        InitItems.ITEMS.add(this);
    }

    @Override
    //Go fuck yourself >:(
    //java.lang.NullPointerException: Can't use a null-name for the registry, object nottoogreggy.objects.items.ItemBase@24a42e9d.
    public void registerModels() {
        NotTooGreggy.proxy.registerItemRenderer(this, 0, "inventory");
    }
}
*/