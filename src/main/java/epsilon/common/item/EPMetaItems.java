package epsilon.common.item;

public class EPMetaItems {

    public static EPMetaItem META_ITEM;

    public static void init() {
        META_ITEM = new EPMetaItem();
        META_ITEM.setRegistryName("epsilon_meta_item");
    }
}
