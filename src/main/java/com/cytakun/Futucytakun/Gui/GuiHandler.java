package com.cytakun.Futucytakun.Gui;

import com.cytakun.Futucytakun.EnergyExtractor.ContainerEnergyextractor;
import com.cytakun.Futucytakun.TileEntity.TileEntityEnergyextractor;
import com.cytakun.Futucytakun.EnergyStorer.ContainerEnergystorer;
import com.cytakun.Futucytakun.TileEntity.TileEntityEnergystorer;
import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

/**
 * Created by Khan Nguyen on 15.03.2015.
 */
public class GuiHandler implements IGuiHandler{
    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        if (ID==15) {
            return new ContainerEnergyextractor(player.inventory,world.getTileEntity(x,y,z));
        }
        if (ID==14) {
            return new ContainerEnergystorer(player.inventory,world.getTileEntity(x,y,z));
        }
        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        if (ID==15) {
            return new GuiEnergyextractor(new ContainerEnergyextractor(player.inventory,world.getTileEntity(x,y,z)),(TileEntityEnergyextractor)world.getTileEntity(x,y,z));
        }
        if (ID==14) {
            return new GuiEnergystorer(new ContainerEnergystorer(player.inventory,world.getTileEntity(x,y,z)),(TileEntityEnergystorer)world.getTileEntity(x,y,z));
        }
        return null;
    }

}
