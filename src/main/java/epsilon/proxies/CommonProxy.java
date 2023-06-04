package epsilon.proxies;
import epsilon.api.util.EPLogger;
import epsilon.common.item.EPMetaItems;
import epsilon.common.recipe.EPRecipeAddition;
import gregtech.api.GregTechAPI;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import epsilon.Epsilon;
import net.minecraft.world.World;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import epsilon.common.materials.EpsilonMaterialHandler;



@Mod.EventBusSubscriber(modid = Epsilon.MOD_ID)
public class CommonProxy {

    public void preLoad() {
        EPLogger.logger.info("I hate endercore -Reclipse");
        EPMetaItems.init();
    }

    public void onLoad() {
        
    }

    public void postLoad() {

    }

    public void onServerStopping(World world) {

    }
    
    @SubscribeEvent(priority = EventPriority.HIGH)
    public static void registerMaterials(GregTechAPI.MaterialEvent event) {
        EpsilonMaterialHandler.init();
    }

    @SubscribeEvent
    public void onWorldLoad(WorldEvent.Load event) {
    }

    @SubscribeEvent
    public void onWorldUnload(WorldEvent.Unload event) {
        onServerStopping(event.getWorld());
    }

    @SubscribeEvent(priority = EventPriority.NORMAL)
    public static void registerRecipes(RegistryEvent.Register<IRecipe> event) {
        EPLogger.logger.info("Registering recipes...");
        EPRecipeAddition.init();
    }

}

