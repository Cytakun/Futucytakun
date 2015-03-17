package com.cytakun.Futucytakun;


import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.material.Material;

@Mod(modid = Futucytakun.MODID, version = Futucytakun.VERSION,name = Futucytakun.MODID)
public class Futucytakun
{
    public static final String MODID = "Futucytakun";
    public static final String VERSION = "1.0";

    @Mod.Instance(MODID)
    public static Futucytakun instance;

    @Mod.EventHandler
    public void preinit(FMLPreInitializationEvent event) {
        GameRegistry.registerBlock(new BlockEnergyextractor(),"Energyextractor" );
        NetworkRegistry.INSTANCE.registerGuiHandler(MODID,new GuiHandler());

    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {

    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {

    }
}
