package nottoogreggy.handlers;

import gregtech.api.unification.material.*;
import gregtech.api.unification.material.Materials.*;
import gregtech.api.GTValues;
import gregtech.api.fluids.fluidType.FluidTypes;
import gregtech.api.unification.material.Materials;
import gregtech.api.unification.material.info.MaterialIconSet;
import gregtech.api.unification.material.properties.BlastProperty;

import static gregtech.api.GTValues.*;
import static gregtech.api.unification.material.info.MaterialFlags.*;
import static gregtech.api.unification.material.info.MaterialIconSet.*;
import static gregtech.api.unification.material.Materials.*;

public class NTGMaterialHandler {

    //EXAMPLE:

    ///public final Material IsopropylChloride = fluidBuilder("isopropyl_chloride")
    //.components(Carbon, 3, Hydrogen, 7, Chlorine, 1)
    //.build()
    //.setFormula("(CH3)2CHCl", true);

    private static int id = 26000;

    //Credits to Bruberu (https://github.com/bruberu) for these function ily
    public static Material.Builder ingotBuilder(String name) {
        id++;
        return new Material.Builder(id, "ntg_" + name).ingot();
    }
    // no need
    public static Material.Builder fluidBuilder(String name) {
        id++;
        return new Material.Builder(id, "ntg_" + name).fluid();
    }
    public static Material Cumshittium;
    public static Material Gadolinium_Oxide;
    public static void init() {
        //////////////////////Fluids//////////////////////

        //////////////////////Ingots//////////////////////
        Gadolinium_Oxide = new Material.Builder(26001, "gadolinium_oxide")
                .ingot()
                .iconSet(SHINY)
                .components(Gadolinium, 2, Oxygen, 3)
                .build();
        Cumshittium = new Material.Builder(26000, "cumshittium")
                .ingot()
                .iconSet(SHINY)
                .build().setFormula("\u2726-H-\u2726");
    }
}