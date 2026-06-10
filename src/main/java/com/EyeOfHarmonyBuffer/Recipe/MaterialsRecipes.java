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
                GTUtility.copyAmountUnsafe(10240,MaterialsUEVplus.MagMatter.getDust(1)),
                GTUtility.copyAmountUnsafe(10240,GTOreDictUnificator.get(OrePrefixes.dust, Materials.Bedrockium, 1)),
                GTUtility.copyAmountUnsafe(10240,MaterialsUEVplus.Eternity.getDust(1)),
                GTUtility.copyAmountUnsafe(10240,Materials.Infinity.getDust(1))

            )
            .fluidInputs(
                MaterialsUEVplus.Antimatter.getFluid(1919),
                MaterialsUEVplus.PhononMedium.getFluid(114514),
                MaterialsUEVplus.QuarkGluonPlasma.getFluid(123123)
            )
            .itemOutputs(
                EOHBCatalyst.get(OrePrefixes.dust, 1)
            )
            .eut(TierEU.RECIPE_UXV)
            .duration(3000 * SECONDS)
            .addTo(mixerNonCellRecipes);

        GTValues.RA.stdBuilder()
            .itemInputsUnsafe(
                GTUtility.copyAmountUnsafe(12800, GTOreDictUnificator.get(OrePrefixes.ingot, MaterialsUEVplus.WhiteDwarfMatter,1)),
                GTUtility.copyAmountUnsafe(12800, GTOreDictUnificator.get(OrePrefixes.ingot, MaterialsUEVplus.BlackDwarfMatter,1)),
                GTUtility.copyAmountUnsafe(12800, getModItem(EternalSingularity.ID, "eternal_singularity",1)),
                GTUtility.copyAmountUnsafe(12800, MaterialsUEVplus.Universium.getIngots(1)),
                EOHBCatalyst.get(OrePrefixes.dust, 1)
            )
            .fluidInputs(
                MaterialsUEVplus.SpaceTime.getMolten(144000)
            )
            .itemOutputs(
                EOHBCatalyst.get(OrePrefixes.ingotHot, 1)
            )
            .eut(TierEU.RECIPE_UXV)
            .duration(300 * SECONDS)
            .metadata(COIL_HEAT, 14999)
            .addTo(godforgeMoltenRecipes);

        GTValues.RA.stdBuilder()
            .itemInputs(
                EOHBCatalyst.get(OrePrefixes.ingotHot, 1)
            )
            .fluidInputs(
                MaterialsUEVplus.Space.getMolten(144000),
                MaterialsUEVplus.Time.getMolten(144000)
            )
            .itemOutputs(
                EOHBCatalyst.get(OrePrefixes.ingot, 1)
            )
            .eut(TierEU.RECIPE_UXV)
            .duration(50 * SECONDS)
            .addTo(vacuumFreezerRecipes);
    }
}
