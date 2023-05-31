package nottoogreggy;

import nottoogreggy.handlers.NTGMaterialHandler;
import nottoogreggy.proxies.CommonProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = NotTooGreggy.MOD_ID, name = NotTooGreggy.MOD_NAME, version = NotTooGreggy.MOD_VERSION)

public class NotTooGreggy {

    public static final String MOD_ID = "nottoogreggy";
    public static final String MOD_NAME = "NTG-Core Mod";
    public static final String MOD_VERSION = "0.0.1";

    @SidedProxy(serverSide = "nottoogreggy.proxies.CommonProxy", clientSide = "nottoogreggy.proxies.ClientProxy", modId = MOD_ID)

    public static CommonProxy proxy;



    //PRE INIT
    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        proxy.preLoad();
        
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

