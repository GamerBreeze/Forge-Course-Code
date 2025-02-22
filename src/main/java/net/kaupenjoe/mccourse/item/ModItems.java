package net.kaupenjoe.mccourse.item;

import net.kaupenjoe.mccourse.MCCourseMod;
import net.kaupenjoe.mccourse.block.ModBlocks;
import net.kaupenjoe.mccourse.item.custom.*;
import net.kaupenjoe.mccourse.sound.ModSounds;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, MCCourseMod.MOD_ID);

    public static final RegistryObject<Item> AZURITE = ITEMS.register("azurite",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_AZURITE = ITEMS.register("raw_azurite",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> CHAINSAW = ITEMS.register("chainsaw",
            () -> new ChainsawItem(new Item.Properties().durability(32)));
    public static final RegistryObject<Item> ONION = ITEMS.register("onion",
            () -> new Item(new Item.Properties().food(ModFoodProperties.ONION)) {
                @Override
                public void appendHoverText(ItemStack pStack, TooltipContext pContext, List<Component> pTooltipComponents, TooltipFlag pTooltipFlag) {
                    pTooltipComponents.add(Component.translatable("tooltip.mccourse.onion.tooltip.1"));
                    super.appendHoverText(pStack, pContext, pTooltipComponents, pTooltipFlag);
                }
            });
    public static final RegistryObject<Item> AURORA_ASHES = ITEMS.register("aurora_ashes",
            () -> new FuelItem(new Item.Properties(), 800));

    public static final RegistryObject<Item> AZURITE_SWORD = ITEMS.register("azurite_sword",
            () -> new ModEffectSwordItem(ModToolTiers.AZURITE, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ModToolTiers.AZURITE, 5, 3f)), MobEffects.LEVITATION));
    public static final RegistryObject<Item> AZURITE_PICKAXE = ITEMS.register("azurite_pickaxe",
            () -> new PickaxeItem(ModToolTiers.AZURITE, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(ModToolTiers.AZURITE, 1.0F, -2.8F))));
    public static final RegistryObject<Item> AZURITE_SHOVEL = ITEMS.register("azurite_shovel",
            () -> new ShovelItem(ModToolTiers.AZURITE, new Item.Properties()
                    .attributes(ShovelItem.createAttributes(ModToolTiers.AZURITE, 1.5F, -3.0F))));
    public static final RegistryObject<Item> AZURITE_AXE = ITEMS.register("azurite_axe",
            () -> new AxeItem(ModToolTiers.AZURITE, new Item.Properties()
                    .attributes(AxeItem.createAttributes(ModToolTiers.AZURITE, 6.0F, -3.2F))));
    public static final RegistryObject<Item> AZURITE_HOE = ITEMS.register("azurite_hoe",
            () -> new HoeItem(ModToolTiers.AZURITE, new Item.Properties()
                    .attributes(HoeItem.createAttributes(ModToolTiers.AZURITE, 0.0F, -3.0F))));

    public static final RegistryObject<Item> AZURITE_PAXEL = ITEMS.register("azurite_paxel",
            () -> new PaxelItem(ModToolTiers.AZURITE, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(ModToolTiers.AZURITE, 2.0F, -2.5F))));
    public static final RegistryObject<Item> AZURITE_HAMMER = ITEMS.register("azurite_hammer",
            () -> new HammerItem(ModToolTiers.AZURITE, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(ModToolTiers.AZURITE, 7.0F, -3.5F))));

    public static final RegistryObject<Item> AZURITE_HELMET = ITEMS.register("azurite_helmet",
            () -> new ModArmorItem(ModArmorMaterials.AZURITE_ARMOR_MATERIAL, ArmorItem.Type.HELMET,
                    new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(11))));
    public static final RegistryObject<Item> AZURITE_CHESTPLATE = ITEMS.register("azurite_chestplate",
            () -> new ArmorItem(ModArmorMaterials.AZURITE_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties().durability(ArmorItem.Type.CHESTPLATE.getDurability(11))));
    public static final RegistryObject<Item> AZURITE_LEGGINGS = ITEMS.register("azurite_leggings",
            () -> new ArmorItem(ModArmorMaterials.AZURITE_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS,
                    new Item.Properties().durability(ArmorItem.Type.LEGGINGS.getDurability(11))));
    public static final RegistryObject<Item> AZURITE_BOOTS = ITEMS.register("azurite_boots",
            () -> new ArmorItem(ModArmorMaterials.AZURITE_ARMOR_MATERIAL, ArmorItem.Type.BOOTS,
                    new Item.Properties().durability(ArmorItem.Type.BOOTS.getDurability(11))));

    public static final RegistryObject<Item> AZURITE_HORSE_ARMOR = ITEMS.register("azurite_horse_armor",
            () -> new AnimalArmorItem(ModArmorMaterials.AZURITE_ARMOR_MATERIAL, AnimalArmorItem.BodyType.EQUESTRIAN, false, new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> KAUPEN_SMITHING_TEMPLATE = ITEMS.register("kaupen_armor_trim_smithing_template",
            () -> SmithingTemplateItem.createArmorTrimTemplate(ResourceLocation.fromNamespaceAndPath(MCCourseMod.MOD_ID, "kaupen")));


    public static final RegistryObject<Item> METAL_DETECTOR = ITEMS.register("metal_detector",
            () -> new MetalDetectorItem(new Item.Properties().durability(100)));

    public static final RegistryObject<Item> DATA_TABLET = ITEMS.register("data_tablet",
            () -> new DataTabletItem(new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> KAUPEN_BOW = ITEMS.register("kaupen_bow",
            () -> new BowItem(new Item.Properties().durability(250)));

    public static final RegistryObject<Item> ONION_SEEDS = ITEMS.register("onion_seeds",
            () -> new ItemNameBlockItem(ModBlocks.ONION_CROP.get(), new Item.Properties()));

    public static final RegistryObject<Item> BAR_BRAWL_MUSIC_DISC = ITEMS.register("bar_brawl_music_disc",
            () -> new Item(new Item.Properties().stacksTo(1).jukeboxPlayable(ModSounds.BAR_BRAWL_KEY)));

    public static final RegistryObject<Item> RADIATION_STAFF = ITEMS.register("radiation_staff",
            () -> new Item(new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> SOUL_STAFF = ITEMS.register("soul_staff",
            () -> new Item(new Item.Properties().stacksTo(1)));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
