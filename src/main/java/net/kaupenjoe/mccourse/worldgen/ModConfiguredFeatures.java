package net.kaupenjoe.mccourse.worldgen;

import net.kaupenjoe.mccourse.MCCourseMod;
import net.kaupenjoe.mccourse.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.CherryFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.ForkingTrunkPlacer;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;

public class ModConfiguredFeatures {
    // CF -> PF -> BM
    public static final ResourceKey<ConfiguredFeature<?, ?>> BALSA_KEY = registerKey("balsa");

    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_AZURITE_ORE_KEY = registerKey("azurite_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> NETHER_AZURITE_ORE_KEY = registerKey("nether_azurite_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> END_AZURITE_ORE_KEY = registerKey("end_azurite_ore");

    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {
        register(context, BALSA_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ModBlocks.BALSA_LOG.get()),
                new ForkingTrunkPlacer(4, 4, 3),
                BlockStateProvider.simple(ModBlocks.BALSA_LEAVES.get()),
                new CherryFoliagePlacer(ConstantInt.of(6), ConstantInt.of(3), ConstantInt.of(7),
                        0.2f, 0.5f, 0.2f, 0.5f),
                new TwoLayersFeatureSize(1, 0, 2)).build());

        RuleTest stoneReplaceables = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceables = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        RuleTest netherrackReplaceables = new BlockMatchTest(Blocks.NETHERRACK);
        RuleTest endReplaceables = new BlockMatchTest(Blocks.END_STONE);

        List<OreConfiguration.TargetBlockState> overworldAzuriteOres = List.of(
                OreConfiguration.target(stoneReplaceables, ModBlocks.AZURITE_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceables, ModBlocks.AZURITE_DEEPSLATE_ORE.get().defaultBlockState()));

        register(context, OVERWORLD_AZURITE_ORE_KEY, Feature.ORE, new OreConfiguration(overworldAzuriteOres, 9));
        register(context, NETHER_AZURITE_ORE_KEY, Feature.ORE, new OreConfiguration(netherrackReplaceables,
                ModBlocks.AZURITE_NETHER_ORE.get().defaultBlockState(), 9));
        register(context, END_AZURITE_ORE_KEY, Feature.ORE, new OreConfiguration(endReplaceables,
                ModBlocks.AZURITE_END_ORE.get().defaultBlockState(), 9));


    }


    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(MCCourseMod.MOD_ID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstrapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }

}
