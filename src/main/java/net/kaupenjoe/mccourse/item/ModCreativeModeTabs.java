package net.kaupenjoe.mccourse.item;

import net.kaupenjoe.mccourse.MCCourseMod;
import net.kaupenjoe.mccourse.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MCCourseMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> AZURITE_ITEMS_TAB = CREATIVE_MODE_TAB.register("azurite_items_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.AZURITE.get()))
                    .title(Component.translatable("creativetab.azurite_items"))
                    .displayItems((itemDisplayParameters, output) -> {

                        output.accept(ModItems.AZURITE_SWORD.get());
                        output.accept(ModItems.AZURITE_PICKAXE.get());
                        output.accept(ModItems.AZURITE_AXE.get());
                        output.accept(ModItems.AZURITE_SHOVEL.get());
                        output.accept(ModItems.AZURITE_HOE.get());

                        output.accept(ModItems.AZURITE_PAXEL.get());

                        output.accept(ModItems.AZURITE_HAMMER.get());

                        output.accept(ModItems.AZURITE_HELMET.get());
                        output.accept(ModItems.AZURITE_CHESTPLATE.get());
                        output.accept(ModItems.AZURITE_LEGGINGS.get());
                        output.accept(ModItems.AZURITE_BOOTS.get());

                        output.accept(ModItems.AZURITE.get());
                        output.accept(ModItems.RAW_AZURITE.get());

                        output.accept(ModItems.CHAINSAW.get());

                        output.accept(ModItems.ONION.get());

                        output.accept(ModItems.AURORA_ASHES.get());

                    }).build());

    public static final RegistryObject<CreativeModeTab> AZURITE_BLOCKS_TAB = CREATIVE_MODE_TAB.register("azurite_blocks_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.AZURITE_BLOCK.get())).withTabsBefore(AZURITE_ITEMS_TAB.getId())
                    .title(Component.translatable("creativetab.azurite_blocks"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(Blocks.HAY_BLOCK);
                        output.accept(ModBlocks.AZURITE_BLOCK.get());

                        output.accept(ModBlocks.AZURITE_STAIRS.get());
                        output.accept(ModBlocks.AZURITE_SLAB.get());

                        output.accept(ModBlocks.AZURITE_PRESSURE_PLATE.get());
                        output.accept(ModBlocks.AZURITE_BUTTON.get());

                        output.accept(ModBlocks.AZURITE_FENCE.get());
                        output.accept(ModBlocks.AZURITE_FENCE_GATE.get());
                        output.accept(ModBlocks.AZURITE_WALL.get());

                        output.accept(ModBlocks.AZURITE_DOOR.get());
                        output.accept(ModBlocks.AZURITE_TRAPDOOR.get());

                        output.accept(ModBlocks.AZURITE_ORE.get());
                        output.accept(ModBlocks.AZURITE_DEEPSLATE_ORE.get());
                        output.accept(ModBlocks.AZURITE_NETHER_ORE.get());
                        output.accept(ModBlocks.AZURITE_END_ORE.get());

                        output.accept(ModBlocks.MAGIC_BLOCK.get());
                    }).build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}