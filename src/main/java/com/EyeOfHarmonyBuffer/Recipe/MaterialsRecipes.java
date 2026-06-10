package com.EyeOfHarmonyBuffer.Recipe;

import com.EyeOfHarmonyBuffer.utils.IRecipePool;
import gregtech.api.enums.*;
import gregtech.api.util.GTOreDictUnificator;
import gregtech.api.util.GTUtility;
import tectech.thing.CustomItemList;

import static com.EyeOfHarmonyBuffer.common.material.EOHBMaterialPool.EOHBCatalyst;
import static gregtech.api.enums.Mods.EternalSingularity;
import static gregtech.api.recipe.RecipeMaps.vacuumFreezerRecipes;
import static gregtech.api.util.GTModHandler.getModItem;
import static gregtech.api.util.GTRecipeBuilder.SECONDS;
import static gregtech.api.util.GTRecipeConstants.COIL_HEAT;
import static gtPlusPlus.api.recipe.GTPPRecipeMaps.mixerNonCellRecipes;
import static tectech.recipe.TecTechRecipeMaps.godforgeMoltenRecipes;

public class MaterialsRecipes implements IRecipePool{

    @Override
    public void loadRecipes() {

        GTValues.RA.stdBuilder()
            .itemInputsUnsafe(
                GTUtility.copyAmount(0, CustomItemList.Machine_Multi_EyeOfHarmony.get(1)),
                GTUtility.copyAmountUnsafe(64,MaterialsUEVplus.MagMatter.getDust(1)),
                GTUtility.copyAmountUnsafe(64,GTOreDictUnificator.get(OrePrefixes.dust, Materials.Bedrockium, 1)),
                GTUtility.copyAmountUnsafe(64,MaterialsUEVplus.Eternity.getDust(1)),
                GTUtility.copyAmountUnsafe(64,Materials.Infinity.getDust(1))

            )
            .fluidInputs(
                MaterialsUEVplus.Antimatter.getFluid(256),
                MaterialsUEVplus.PhononMedium.getFluid(10000),
                MaterialsUEVplus.QuarkGluonPlasma.getFluid(10000)
            )
            .itemOutputs(
                EOHBCatalyst.get(OrePrefixes.dust, 1)
            )
            .eut(TierEU.RECIPE_UXV)
            .duration(300 * SECONDS)
            .addTo(mixerNonCellRecipes);

        GTValues.RA.stdBuilder()
            .itemInputsUnsafe(
                GTUtility.copyAmountUnsafe(256, GTOreDictUnificator.get(OrePrefixes.ingot, MaterialsUEVplus.WhiteDwarfMatter,1)),
                GTUtility.copyAmountUnsafe(256, GTOreDictUnificator.get(OrePrefixes.ingot, MaterialsUEVplus.BlackDwarfMatter,1)),
                GTUtility.copyAmountUnsafe(256, getModItem(EternalSingularity.ID, "eternal_singularity",1)),
                GTUtility.copyAmountUnsafe(256, MaterialsUEVplus.Universium.getIngots(1)),
                EOHBCatalyst.get(OrePrefixes.dust, 1)
            )
            .fluidInputs(
                MaterialsUEVplus.SpaceTime.getMolten(10000)
            )
            .itemOutputs(
                EOHBCatalyst.get(OrePrefixes.ingotHot, 1)
            )
            .eut(TierEU.RECIPE_UXV)
            .duration(30 * SECONDS)
            .metadata(COIL_HEAT, 14999)
            .addTo(godforgeMoltenRecipes);

        GTValues.RA.stdBuilder()
            .itemInputs(
                EOHBCatalyst.get(OrePrefixes.ingotHot, 1)
            )
            .fluidInputs(
                MaterialsUEVplus.Space.getMolten(10000),
                MaterialsUEVplus.Time.getMolten(10000)
            )
            .itemOutputs(
                EOHBCatalyst.get(OrePrefixes.ingot, 1)
            )
            .eut(TierEU.RECIPE_UXV)
            .duration(5 * SECONDS)
            .addTo(vacuumFreezerRecipes);
    }
}
