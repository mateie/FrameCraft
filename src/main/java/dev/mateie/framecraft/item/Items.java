package dev.mateie.framecraft.item;

import dev.mateie.framecraft.FrameCraft;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class Items {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, FrameCraft.MOD_ID);


    // Resource Items
    public static final RegistryObject<Item> ALLOY_PLATE = ITEMS.register("alloy_plate",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ARGON_CRYSTAL = ITEMS.register("argon_crystal",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> CIRCUITS = ITEMS.register("circuits",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> CONTROL_MODULE = ITEMS.register("control_module",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> CRYOTIC = ITEMS.register("cryotic",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> DETONITE_AMPULE = ITEMS.register("detonite_ampule",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> FERRITE = ITEMS.register("ferrite",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> FIELDRON_SAMPLE = ITEMS.register("fieldron_sample",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> GALLIUM = ITEMS.register("gallium",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> HEXENON = ITEMS.register("hexenon",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> MORPHICS = ITEMS.register("morphics",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> MUTAGEN_SAMPLE = ITEMS.register("mutagen_sample",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> NANO_SPORES = ITEMS.register("nano_spores",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> NEURAL_SENSORS = ITEMS.register("neural_sensors",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> NEURODES = ITEMS.register("neurodes",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> OROKIN_CELL = ITEMS.register("orokin_cell",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> PLASTIDS = ITEMS.register("plastids",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> POLYMER_BUNDLE = ITEMS.register("polymer_bundle",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RUBEDO = ITEMS.register("rubedo",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> SALVAGE = ITEMS.register("salvage",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> TELLURIUM = ITEMS.register("tellurium",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
