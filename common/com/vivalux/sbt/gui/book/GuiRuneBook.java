package com.vivalux.sbt.gui.book;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.resources.I18n;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

import com.vivalux.sbt.Subterrania_ModBase;
import com.vivalux.sbt.gui.GuiButtonNextPage;
import com.vivalux.sbt.gui.book.page.Page;

public class GuiRuneBook extends GuiScreen {

    Book book = Subterrania_ModBase.proxy.runebook;
    private int bookImageWidth = 192;
    private int bookImageHeight = 192;
    private GuiButtonNextPage buttonNextPage;
    private GuiButtonNextPage buttonPreviousPage;

    public int currPage = 0;
    public Page[] pages = this.book.pages;
    public int pageCount = this.book.pages.length;

    public GuiRuneBook() {
	super();
    }

    public void initGui() {
	this.buttonList.clear();
	Keyboard.enableRepeatEvents(true);

	int i = (this.width - this.bookImageWidth) / 2;
	byte b0 = 2;
	this.buttonList.add(this.buttonNextPage = new GuiButtonNextPage(1,
		i + 120, b0 + 154, true));
	this.buttonList.add(this.buttonPreviousPage = new GuiButtonNextPage(2,
		i + 38, b0 + 154, false));
	this.updateButtons();
    }

    private void updateButtons() {
	this.buttonNextPage.drawButton = (this.currPage < this.pages.length - 1);
	this.buttonPreviousPage.drawButton = this.currPage > 0;

    }

    protected void actionPerformed(GuiButton par1GuiButton) {
	if (par1GuiButton.enabled) {
	    if (par1GuiButton.id == 1) {
		if (this.currPage < this.pages.length) {
		    ++this.currPage;
		}
	    } else if (par1GuiButton.id == 2) {
		if (this.currPage > 0) {
		    --this.currPage;
		}
	    }

	    this.updateButtons();
	}
    }

    public void drawScreen(int par1, int par2, float par3) {
	GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
	this.mc.getTextureManager().bindTexture(
		new ResourceLocation("textures/gui/book.png"));
	int k = (this.width - this.bookImageWidth) / 2;
	byte b0 = 2;
	this.drawTexturedModalRect(k, b0, 0, 0, this.bookImageWidth,
		this.bookImageHeight);
	String s;
	String s1;
	int l;
	s = String.format(
		I18n.getString("book.pageIndicator"),
		new Object[] { Integer.valueOf(this.currPage + 1),
			Integer.valueOf(this.pages.length) });
	s1 = "";

	l = this.fontRenderer.getStringWidth(s);
	this.fontRenderer.drawString(s, k - l + this.bookImageWidth - 44,
		b0 + 16, 0);
	this.fontRenderer.drawSplitString(s1, k + 36, b0 + 16 + 16, 116, 0);

	this.fontRenderer.drawSplitString(this.pages[currPage].text[0], k + 36,
		b0 + 16 + 16, 116, 0);

	if (this.pages[currPage].icons.length > 0) {
	    this.drawImage(this.pages[currPage].icons[0], 290, 120, 48, 48);

	}

	super.drawScreen(par1, par2, par3);
    }

    private void drawImage(ResourceLocation path, int x, int y, int x2, int y2) {

	GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
	this.mc.getTextureManager().bindTexture(path);
	Tessellator tessellator = Tessellator.instance;
	tessellator.startDrawingQuads();
	tessellator.addVertexWithUV(x + 0, y + y2, this.zLevel, 0, 1);// Bottom
								      // left
	tessellator.addVertexWithUV(x + x2, y + y2, this.zLevel, 1, 1);// Bottom
								       // right
	tessellator.addVertexWithUV(x + x2, y + 0, this.zLevel, 1, 0);// Top
								      // right
	tessellator.addVertexWithUV(x + 0, y + 0, this.zLevel, 0, 0); // Top
								      // left
	tessellator.draw();

    }

}
