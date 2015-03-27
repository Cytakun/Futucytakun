package com.cytakun.Futucytakun.EnergyExtractor;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

import java.util.List;

/**
 * Created by Khan Nguyen on 22.03.2015.
 */
public class ItemBlockEnergyextractor extends ItemBlock {
    public ItemBlockEnergyextractor(Block p_i45328_1_) {
        super(p_i45328_1_);
    }

    @Override
    public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean p_77624_4_) {
        list.add("Power with coal");
        super.addInformation(itemStack, player, list, p_77624_4_);
    }
}
