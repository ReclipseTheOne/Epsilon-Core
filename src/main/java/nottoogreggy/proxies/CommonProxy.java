package nottoogreggy.proxies;
import gregtech.api.GregTechAPI;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import nottoogreggy.NotTooGreggy;
import net.minecraft.world.World;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import nottoogreggy.handlers.NTGMaterialHandler;



@Mod.EventBusSubscriber(modid = NotTooGreggy.MOD_ID)
public class CommonProxy {

    public void preLoad() {
    }

    public void onLoad() {
        
    }

    public void postLoad() {

    }

    public void onServerStopping(World world) {

    }
    
    @SubscribeEvent(priority = EventPriority.HIGH)
    public static void registerMaterials(GregTechAPI.MaterialEvent event) {
        NTGMaterialHandler.init();
    }

    @SubscribeEvent
    public void onWorldLoad(WorldEvent.Load event) {
    }

    @SubscribeEvent
    public void onWorldUnload(WorldEvent.Unload event) {
        onServerStopping(event.getWorld());
    }

    public void registerItemRenderer(Item item, int meta, String id) {}

}

