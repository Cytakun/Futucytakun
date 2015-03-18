package com.cytakun.Futucytakun;

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
        return null;

    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        if (ID==15) {
            return new GuiEnergyextractor(new ContainerEnergyextractor(player.inventory,world.getTileEntity(x,y,z)),(TileEntityEnergyextractor)world.getTileEntity(x,y,z));

        }
        return null;
    }
}
