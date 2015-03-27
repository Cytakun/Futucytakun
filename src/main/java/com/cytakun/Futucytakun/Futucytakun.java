package com.cytakun.Futucytakun;


import com.cytakun.Futucytakun.EnergyExtractor.BlockEnergyextractor;
import com.cytakun.Futucytakun.EnergyExtractor.ItemBlockEnergyextractor;
import com.cytakun.Futucytakun.Items.Energycell;
import com.cytakun.Futucytakun.Items.Energycontainer;
import com.cytakun.Futucytakun.Items.PortableEnergyContainer;
import com.cytakun.Futucytakun.TileEntity.TileEntityEnergyextractor;
import com.cytakun.Futucytakun.EnergyStorer.BlockEnergystorer;
import com.cytakun.Futucytakun.TileEntity.TileEntityEnergystorer;
import com.cytakun.Futucytakun.Gui.GuiHandler;
import com.cytakun.Futucytakun.Items.Energycleaver;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.creativetab.CreativeTabs;


@Mod(modid = Futucytakun.MODID, version = Futucytakun.VERSION,name = Futucytakun.MODID)
public class Futucytakun
{
    public static final String MODID = "Futucytakun";
    public static final String VERSION = "1.0";

    @Mod.Instance(MODID)
    public static Futucytakun instance;
    public static CreativeTabs Futucytakun = new FutucytakunTab(CreativeTabs.getNextID(),"Futucytakun");

    //Blocks
    public static BlockEnergyextractor Energyextractor = (BlockEnergyextractor) new BlockEnergyextractor().setCreativeTab(Futucytakun);
    public static BlockEnergystorer Energystorer = (BlockEnergystorer) new BlockEnergystorer().setCreativeTab(Futucytakun);

    //Items
    public static Energycleaver Energycleaver = (Energycleaver) new Energycleaver();
    public static PortableEnergyContainer PortableEnergyContainer = (PortableEnergyContainer) new PortableEnergyContainer();
    public static Energycell Energycell = (Energycell) new Energycell();
    public static Energycontainer Energycontainer = (Energycontainer) new Energycontainer();

    @Mod.EventHandler
    public void preinit(FMLPreInitializationEvent event) {
        NetworkRegistry.INSTANCE.registerGuiHandler(MODID,new GuiHandler());

        GameRegistry.registerBlock(Energyextractor, ItemBlockEnergyextractor.class,"Energyextractor");
        GameRegistry.registerTileEntity(TileEntityEnergyextractor.class,"TileEntityEnergyextractor");

        GameRegistry.registerBlock(Energystorer,"Energystorer");
        GameRegistry.registerTileEntity(TileEntityEnergystorer.class, "TileEntityEnergystorer");

        GameRegistry.registerItem(Energycleaver,"Energycleaver");

        GameRegistry.registerItem(PortableEnergyContainer, "PortableEnergyContainer");

        GameRegistry.registerItem(Energycell,"Energycell");

        GameRegistry.registerItem(Energycontainer, "Energycontainer");

        Recipes.registerRecipes();
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {

    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {

    }
}