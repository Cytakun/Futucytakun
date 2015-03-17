package com.cytakun.Futucytakun;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;



/**
 * Created by Khan Nguyen on 15.03.2015.
 */
public class GuiEnergyextractor extends GuiContainer{
    public GuiEnergyextractor(Container p_i1072_1_) {
        super(p_i1072_1_);
        xSize=175;
        ySize=142;
    }
    int CK=15;
    @Override
    protected void drawGuiContainerBackgroundLayer(float p_146976_1_, int p_146976_2_, int p_146976_3_) {
        Minecraft.getMinecraft().getTextureManager().bindTexture(Texture);
        drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
        drawString(fontRendererObj, String.valueOf(CK), width / 2, height / 4, 0x44ff11);


    }
    public static final ResourceLocation Texture=new ResourceLocation("futucytakun", "textures/gui/energyextractor.png");
}
