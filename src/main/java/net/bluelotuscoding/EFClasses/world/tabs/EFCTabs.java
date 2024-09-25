package net.bluelotuscoding.EFClasses.world.tabs;

import net.bluelotuscoding.EFClasses.main.EpicFightClassesMod;
import net.bluelotuscoding.EFClasses.world.item.EFCItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.rmi.registry.Registry;
import java.util.function.Supplier;

public class EFCTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, EpicFightClassesMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> EFTab_Weapons = CREATIVE_MODE_TAB.register("weapons_tab",
            ()-> CreativeModeTab.builder().icon(() -> new ItemStack(EFCItems.OATH_TAKER.get()))
                    .title(Component.translatable("EFCtab.weapontab"))
                    .displayItems((DisplayParameters, output) -> {
                        //This setup here displays specific items in this creative mode tab!
                        output.accept(EFCItems.OATH_TAKER.get());
                        output.accept(EFCItems.AMON.get());
                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
