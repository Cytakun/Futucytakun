package com.cytakun.Futucytakun;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

/**
 * Created by Khan Nguyen on 22.03.2015.
 */
public class FutucytakunTab extends CreativeTabs{
    public FutucytakunTab(int FutucytakunTab, String lable) {
        super(lable);
    }

    @Override
    public Item getTabIconItem() {
        return Items.diamond;
    }
}
