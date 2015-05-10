package com.cytakun.Futucytakun.EnergyStorer;

import com.cytakun.Futucytakun.Futucytakun;
import com.cytakun.Futucytakun.TileEntity.TileEntityEnergystorer;
import cpw.mods.fml.common.network.internal.FMLNetworkHandler;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

/**
 * Created by Khan Nguyen on 20.03.2015.
 */
public class BlockEnergystorer extends BlockContainer{

    public IIcon[] icons = new IIcon[6];

    public BlockEnergystorer() {
        super(Material.grass);
        setBlockName("Energystorer");
        setHardness(2f);
    }


    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_) {
        if (!world.isRemote) {
            FMLNetworkHandler.openGui(player, Futucytakun.instance, 14, world, x, y, z);

        }
        return true;
    }

    @Override
    public TileEntity createNewTileEntity(World world, int p_149915_2_) {
        return new TileEntityEnergystorer();

    }
    @Override
    public void registerBlockIcons(IIconRegister RegBlock) {

        int x=0;
        while(x<6) {
            icons[x]=RegBlock.registerIcon("futucytakun:ES"+x);
            x=x+1;
        }

    }
    @Override
    public IIcon getIcon(int side, int meta) {
        return this.icons[side];
    }

    @Override
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entityLivingBase, ItemStack itemStack) {
        int i = MathHelper.floor_double((double) (entityLivingBase.rotationYaw * 4.0F / 30.0F) + 5.0D) &3;
        if (i == 0) {
            world.setBlockMetadataWithNotify(x, y, z, 2, 2);
        }
        if (i == 1) {
            world.setBlockMetadataWithNotify(x, y, z, 5, 2);
        }
        if (i == 2) {
            world.setBlockMetadataWithNotify(x, y, z, 3, 2);
        }
        if (i == 3) {
            world.setBlockMetadataWithNotify(x, y, z, 4, 2);
        }
        super.onBlockPlacedBy(world, x, y, z, entityLivingBase, itemStack);
    }
}
