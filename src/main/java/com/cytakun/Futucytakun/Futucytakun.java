package com.cytakun.Futucytakun;


import com.cytakun.Futucytakun.EnergyExtractor.BlockEnergyextractor;
import com.cytakun.Futucytakun.EnergyExtractor.TileEntityEnergyextractor;
import com.cytakun.Futucytakun.EnergyStorer.BlockEnergystorer;
import com.cytakun.Futucytakun.EnergyStorer.TileEntityEnergystorer;
import com.cytakun.Futucytakun.Gui.GuiHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = Futucytakun.MODID, version = Futucytakun.VERSION,name = Futucytakun.MODID)
public class Futucytakun
{
    public static final String MODID = "Futucytakun";
    public static final String VERSION = "1.0";

    @Mod.Instance(MODID)
    public static Futucytakun instance;
    public static BlockEnergyextractor Energyextractor = new BlockEnergyextractor();
    public static BlockEnergystorer Energystorer = new BlockEnergystorer();

    @Mod.EventHandler
    public void preinit(FMLPreInitializationEvent event) {
        NetworkRegistry.INSTANCE.registerGuiHandler(MODID,new GuiHandler());

        GameRegistry.registerBlock(Energyextractor,"Energyextractor");
        GameRegistry.registerTileEntity(TileEntityEnergyextractor.class,"TileEntityEnergyextractor");

        GameRegistry.registerBlock(Energystorer,"Energystorer");
        GameRegistry.registerTileEntity(TileEntityEnergystorer.class, "TileEntityEnergystorer");
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {

    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {

    }
}