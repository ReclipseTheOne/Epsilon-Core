package epsilon;

import epsilon.common.machines.EPMetaTileEntities;
import epsilon.proxies.CommonProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Epsilon.MOD_ID, name = Epsilon.MOD_NAME, version = Epsilon.MOD_VERSION)

public class Epsilon {

    public static final String MOD_ID = "epsilon";
    public static final String MOD_NAME = "Epsilon Core-Mod";
    public static final String MOD_VERSION = "0.0.1";

    @SidedProxy(serverSide = "epsilon.proxies.CommonProxy", clientSide = "epsilon.proxies.ClientProxy", modId = MOD_ID)

    public static CommonProxy proxy;



    //PRE INIT
    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        proxy.preLoad();
        EPMetaTileEntities.init();
    }

    //INIT
    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.onLoad();
    }

    //POST INIT
    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postLoad();
    }





}

