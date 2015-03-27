package com.cytakun.Futucytakun.Gui;

import com.cytakun.Futucytakun.TileEntity.TileEntityEnergyextractor;
import com.cytakun.Futucytakun.SecondHand;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;

/**
 * Created by Khan Nguyen on 15.03.2015.
 */
public class GuiEnergyextractor extends GuiContainer{
    public GuiEnergyextractor(Container p_i1072_1_,TileEntityEnergyextractor CK) {
        super(p_i1072_1_);
        xSize=175;
        ySize=142;
        this.CK=CK;
    }
    TileEntityEnergyextractor CK;

    ResourceLocation ZeroEnergy = new ResourceLocation("futucytakun", "textures/gui/ZeroEnergy.png");
    ResourceLocation FullEnergy = new ResourceLocation("futucytakun", "textures/gui/FullEnergy.png");

    @Override
    protected void drawGuiContainerBackgroundLayer(float p_146976_1_, int p_146976_2_, int p_146976_3_) {
        int x= (int) (35-35f/10000f*(float)CK.CK);
        Minecraft.getMinecraft().getTextureManager().bindTexture(Texture);
        drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
        drawString(fontRendererObj, String.valueOf(CK.CK), width / 2, height / 4, 0x44ff11);
        SecondHand.setTexture(FullEnergy);
        SecondHand.drawTexturedModalRect(guiLeft+135,guiTop+12,0,0,14,35,14,35);
        SecondHand.setTexture(ZeroEnergy);
        SecondHand.drawTexturedModalRect(guiLeft+135,guiTop+12,0,0,14,x,14,35);
    }

    public static final ResourceLocation Texture=new ResourceLocation("futucytakun", "textures/gui/energyextractor.png");
}
