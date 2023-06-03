package epsilon.common.recipe;

import gregtech.api.gui.GuiTextures;
import gregtech.api.gui.widgets.ProgressWidget;
import gregtech.api.recipes.RecipeMap;
import gregtech.api.recipes.builders.SimpleRecipeBuilder;
import gregtech.core.sound.GTSoundEvents;

public class EPRecipeMaps {

    public static final RecipeMap<SimpleRecipeBuilder> ENCHANT_DUPLICATING_RECIPES = new RecipeMap<>("enchant_duplicating",
            1, 1, 1, 1, 1, 1, 0, 1, new SimpleRecipeBuilder(), false)
            .setSound(GTSoundEvents.ARC)
            .setProgressBar(GuiTextures.PROGRESS_BAR_REPLICATOR, ProgressWidget.MoveType.HORIZONTAL);

    public static final RecipeMap<SimpleRecipeBuilder> ENCHANT_PROGRAMMING_RECIPES = new RecipeMap<>("enchant_programming",
            2, 2, 1, 1, 1, 1, 0, 1, new SimpleRecipeBuilder(), false)
            .setSound(GTSoundEvents.ARC)
            .setProgressBar(GuiTextures.PROGRESS_BAR_REPLICATOR, ProgressWidget.MoveType.HORIZONTAL);

}
