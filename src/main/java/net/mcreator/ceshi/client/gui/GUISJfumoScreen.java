package net.mcreator.ceshi.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.ceshi.world.inventory.GUISJfumoMenu;
import net.mcreator.ceshi.procedures.GUIfumopinzhixianshi3Procedure;
import net.mcreator.ceshi.procedures.GUIfumopinzhixianshi2Procedure;
import net.mcreator.ceshi.procedures.GUIfumopinzhixianshi1Procedure;
import net.mcreator.ceshi.procedures.GUIfumopinzhixianshi0Procedure;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class GUISJfumoScreen extends AbstractContainerScreen<GUISJfumoMenu> {
	private final static HashMap<String, Object> guistate = GUISJfumoMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;

	public GUISJfumoScreen(GUISJfumoMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("primogemcraft:textures/screens/guis_jfumo.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
		if (GUIfumopinzhixianshi0Procedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("primogemcraft:textures/screens/guifu_bai.png"), this.leftPos + 57, this.topPos + 15, 0, 0, 61, 55, 61, 55);
		}
		if (GUIfumopinzhixianshi1Procedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("primogemcraft:textures/screens/guifu_lan.png"), this.leftPos + 57, this.topPos + 15, 0, 0, 61, 55, 61, 55);
		}
		if (GUIfumopinzhixianshi2Procedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("primogemcraft:textures/screens/guifu_huang.png"), this.leftPos + 57, this.topPos + 15, 0, 0, 61, 55, 61, 55);
		}
		if (GUIfumopinzhixianshi3Procedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("primogemcraft:textures/screens/guifu_rhong.png"), this.leftPos + 57, this.topPos + 15, 0, 0, 61, 55, 61, 55);
		}
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font, Component.translatable("gui.primogemcraft.guis_jfumo.label_fang_ru_ke_fu_mo_wu_pin"), 6, 5, -5070724, false);
	}

	@Override
	public void init() {
		super.init();
	}
}
