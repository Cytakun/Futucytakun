package com.cytakun.Futucytakun.EnergyTransformer;

import com.cytakun.Futucytakun.TileEntity.TileEntityEnergytransformer;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

/**
 * Created by Khan Nguyen on 28.03.2015.
 */
public class BlockEnergytransformer extends BlockContainer{

    public IIcon[] icons = new IIcon[6];

    public BlockEnergytransformer() {
        super(Material.grass);
        setBlockName("Energytransformer");
        setHardness(2f);
    }


    @Override
    public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
        return new TileEntityEnergytransformer();
    }

    @Override
    public void registerBlockIcons(IIconRegister RegBlock) {

        int x=0;
        while(x<6) {
            icons[x] = RegBlock.registerIcon("futucytakun:ET" + x);
            x = x + 1;
        }
    }
    @Override
    public IIcon getIcon(int side, int meta) {
        return this.icons[side];
    }
}
