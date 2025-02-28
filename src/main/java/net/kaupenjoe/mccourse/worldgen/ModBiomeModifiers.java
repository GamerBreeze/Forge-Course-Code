package net.kaupenjoe.mccourse.worldgen;

import net.kaupenjoe.mccourse.MCCourseMod;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ForgeBiomeModifiers;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBiomeModifiers {
    public static final ResourceKey<BiomeModifier> ADD_TREE_BALSA = registerKey("add_tree_balsa");

    public static final ResourceKey<BiomeModifier> ADD_AZURITE_ORE = registerKey("add_azurite_ore");
    public static final ResourceKey<BiomeModifier> ADD_NETHER_AZURITE_ORE = registerKey("add_nether_azurite_ore");
    public static final ResourceKey<BiomeModifier> ADD_END_AZURITE_ORE = registerKey("add_end_azurite_ore");

    public static void bootstrap(BootstrapContext<BiomeModifier> context) {
        var placedFeatures = context.lookup(Registries.PLACED_FEATURE);
        var biomes = context.lookup(Registries.BIOME);

        context.register(ADD_TREE_BALSA, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                HolderSet.direct(biomes.getOrThrow(Biomes.PLAINS), biomes.getOrThrow(Biomes.SAVANNA)),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.BALSA_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION));

        context.register(ADD_AZURITE_ORE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.AZURITE_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES
        ));
        context.register(ADD_NETHER_AZURITE_ORE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_NETHER),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.NETHER_AZURITE_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES
        ));
        context.register(ADD_END_AZURITE_ORE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_END),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.END_AZURITE_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES
        ));

    }

    private static ResourceKey<BiomeModifier> registerKey(String name) {
        return ResourceKey.create(ForgeRegistries.Keys.BIOME_MODIFIERS, ResourceLocation.fromNamespaceAndPath(MCCourseMod.MOD_ID, name));
    }
}
