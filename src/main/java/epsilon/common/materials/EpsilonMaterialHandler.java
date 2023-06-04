package epsilon.common.materials;

import epsilon.api.util.EPLogger;
import gregtech.api.unification.material.*;

import static gregtech.api.unification.material.info.MaterialIconSet.*;
import static gregtech.api.unification.material.Materials.*;

public class EpsilonMaterialHandler {

    //EXAMPLE:

    ///public final Material IsopropylChloride = fluidBuilder("isopropyl_chloride")
    //.components(Carbon, 3, Hydrogen, 7, Chlorine, 1)
    //.build()
    //.setFormula("(CH3)2CHCl", true);

    private static int id = 26000;

    //Credits to Bruberu (https://github.com/bruberu) for these function ily
    public static Material.Builder ingotBuilder(String name) {
        id++;
        EPLogger.logger.info("Registering material " + name + ", and id '" + id+ "', full localization name: material.epsilon_" + name);
        return new Material.Builder(id, "epsilon_" + name).ingot();
    }

    public static Material.Builder fluidBuilder(String name) {
        id++;
        EPLogger.logger.info("Registering fluid with name '" + name + "', and id '" + id + "', full localization name: material.epsilon_" + name);
        return new Material.Builder(id, "epsilon_" + name).fluid();
    }




    public static Material Cumshittium;
    public static Material IsopropylChloride;



    public static void init() {
        //////////////////////Fluids//////////////////////
        EPLogger.logger.info("Starting to register fluids...");



        IsopropylChloride = fluidBuilder("isopropyl_chloride")
                .components(Carbon, 3, Hydrogen, 7, Chlorine, 1)
                .build()
                .setFormula("(CH3)2CHCl", true);



        EPLogger.logger.info("Finsihed registering fluids, thank you for waiting!");







        //////////////////////Ingots//////////////////////
        EPLogger.logger.info("Starting to register ingots...");



        Cumshittium = ingotBuilder("cumshittium")
                .iconSet(SHINY)
                .build()
                .setFormula("✦-H-✦", true);



        EPLogger.logger.info("Finsihed registering ingots, thank you for waiting!");
    }
}