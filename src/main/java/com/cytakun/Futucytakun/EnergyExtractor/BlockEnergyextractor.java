package com.cytakun.Futucytakun.EnergyExtractor;

import com.cytakun.Futucytakun.Futucytakun;
import com.cytakun.Futucytakun.TileEntity.TileEntityEnergyextractor;
import cpw.mods.fml.common.network.internal.FMLNetworkHandler;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

import javax.swing.*;

/**
 * Created by Khan Nguyen on 15.03.2015.
 */
public class BlockEnergyextractor extends BlockContainer{

    public IIcon[] icons = new IIcon[6];

    //Konstruktor
    public BlockEnergyextractor() {
        super(Material.grass);
        setBlockName("Energyextractor");
        setHardness(2f);
    }

    @Override
    public TileEntity createNewTileEntity(World world, int p_149915_2_) {
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
        this.blockIcon = RegBlock.registerIcon(Futucytakun.MODID + ":" + "BlockEnergyextractor_side");
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

    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entityLivingBase, ItemStack itemStack) {
        int l = MathHelper.floor_double((double) (entityLivingBase.rotationYaw * 4.0F / 30.0F)+ 5.0D) & 3;

        TileEntityEnergyextractor tileEntity = (TileEntityEnergyextractor) world.getTileEntity(x, y, z);

        byte facing = 3;

        switch (l) {
            case 0:
                facing = 2;
                break;
            case 1:
                facing = 5;
                break;
            case 3:
                facing = 4;
                break;
        }

        tileEntity.facing = facing;
        world.setBlockMetadataWithNotify(x, y, z, itemStack.getItemDamage(), 2);

    }
}
