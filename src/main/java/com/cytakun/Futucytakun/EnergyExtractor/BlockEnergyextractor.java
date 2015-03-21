package com.cytakun.Futucytakun.EnergyExtractor;

import com.cytakun.Futucytakun.Futucytakun;
import cpw.mods.fml.common.network.internal.FMLNetworkHandler;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

/**
 * Created by Khan Nguyen on 15.03.2015.
 */
public class BlockEnergyextractor extends BlockContainer{

    public IIcon[] icons = new IIcon[6];

    //Konstruktor
    public BlockEnergyextractor() {
        super(Material.anvil);
        setBlockName("Energyextractor");
        setCreativeTab(CreativeTabs.tabMisc);
    }

    @Override
    public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
        return new TileEntityEnergyextractor();
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int meta, float p_149727_7_, float p_149727_8_, float p_149727_9_) {
        if (!world.isRemote) {
            FMLNetworkHandler.openGui(player, Futucytakun.instance, 15, world, x, y, z);

        }
        return true;
    }
    @Override
    public void registerBlockIcons(IIconRegister RegBlock) {

        int x=0;
        while(x<6) {
            icons[x]=RegBlock.registerIcon("futucytakun:EE"+x);
            x=x+1;
        }

    }
    @Override
    public IIcon getIcon(int side, int meta) {
        return this.icons[side];
    }
}
