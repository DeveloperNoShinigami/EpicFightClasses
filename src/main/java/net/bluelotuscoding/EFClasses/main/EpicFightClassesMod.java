package net.bluelotuscoding.EFClasses.main;

import com.mojang.logging.LogUtils;
import net.bluelotuscoding.EFClasses.gameasset.EFCAnimations;
import net.bluelotuscoding.EFClasses.world.capabilities.item.EFCWeaponCapabilityPresets;
import net.bluelotuscoding.EFClasses.world.item.EFCItems;
import net.bluelotuscoding.EFClasses.world.tabs.EFCTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(EpicFightClassesMod.MOD_ID)
public class EpicFightClassesMod
{
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "epicfightclasses";
    // Directly reference a slf4j logger

    private static final Logger LOGGER = LogManager.getLogger("epicfightclasses");

    private static EpicFightClassesMod instance;

    public static EpicFightClassesMod getInstance() {
        return instance;
    }

    public EpicFightClassesMod()
    {
        instance = this;
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        //Classes we are adding in the mod
        EFCItems.register(modEventBus);
        EFCTabs.register(modEventBus);

        //Registered the animations!
        modEventBus.addListener(EFCAnimations::registerAnimations);
        //Registered the capabilities
        modEventBus.addListener(EFCWeaponCapabilityPresets::register);

        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);
        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {

    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {

    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {

        }
    }
}
