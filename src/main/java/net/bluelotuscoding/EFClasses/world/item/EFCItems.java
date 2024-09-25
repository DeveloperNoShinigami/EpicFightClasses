package net.bluelotuscoding.EFClasses.world.item;

import net.bluelotuscoding.EFClasses.main.EpicFightClassesMod;
import net.bluelotuscoding.EFClasses.world.item.weapons.AmonItem;
import net.bluelotuscoding.EFClasses.world.item.weapons.OathTakerItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class EFCItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, EpicFightClassesMod.MOD_ID);


    //Here we register the weapons we are going to include in the mod.
    public static final RegistryObject<Item> OATH_TAKER = ITEMS.register("oath_taker",
            ()->new OathTakerItem(new Item.Properties()));
    public static final RegistryObject<Item> AMON = ITEMS.register("amon",
            ()->new AmonItem(new Item.Properties()));








    public static void register (IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
