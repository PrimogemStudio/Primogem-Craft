package net.mcreator.ceshi.client.gui;

import net.neoforged.neoforge.network.PacketDistributor;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.WidgetSprites;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.ceshi.world.inventory.GUIhualiduanzaotaiMenu;
import net.mcreator.ceshi.network.GUIhualiduanzaotaiButtonMessage;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class GUIhualiduanzaotaiScreen extends AbstractContainerScreen<GUIhualiduanzaotaiMenu> {
	private final static HashMap<String, Object> guistate = GUIhualiduanzaotaiMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	ImageButton imagebutton_guifu_lan;
	ImageButton imagebutton_guifu_huang;

	public GUIhualiduanzaotaiScreen(GUIhualiduanzaotaiMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = ResourceLocation.parse("primogemcraft:textures/screens/gu_ihualiduanzaotai.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics, mouseX, mouseY, partialTicks);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
		if (mouseX > leftPos + 130 && mouseX < leftPos + 147 && mouseY > topPos + 57 && mouseY < topPos + 65) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.primogemcraft.gu_ihualiduanzaotai.tooltip_proc_gu_ihldztmiaoshu"), mouseX, mouseY);
		}
		if (mouseX > leftPos + 130 && mouseX < leftPos + 147 && mouseY > topPos + 22 && mouseY < topPos + 30) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.primogemcraft.gu_ihualiduanzaotai.tooltip_ssbssljing_lian"), mouseX, mouseY);
		}
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
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
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
	}

	@Override
	public void init() {
		super.init();
		imagebutton_guifu_lan = new ImageButton(this.leftPos + 130, this.topPos + 22, 17, 8,
				new WidgetSprites(ResourceLocation.parse("primogemcraft:textures/screens/guifu_lan.png"), ResourceLocation.parse("primogemcraft:textures/screens/anniu_bai.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new GUIhualiduanzaotaiButtonMessage(0, x, y, z));
						GUIhualiduanzaotaiButtonMessage.handleButtonAction(entity, 0, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_guifu_lan", imagebutton_guifu_lan);
		this.addRenderableWidget(imagebutton_guifu_lan);
		imagebutton_guifu_huang = new ImageButton(this.leftPos + 130, this.topPos + 57, 17, 8,
				new WidgetSprites(ResourceLocation.parse("primogemcraft:textures/screens/guifu_huang.png"), ResourceLocation.parse("primogemcraft:textures/screens/anniu_bai.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new GUIhualiduanzaotaiButtonMessage(1, x, y, z));
						GUIhualiduanzaotaiButtonMessage.handleButtonAction(entity, 1, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_guifu_huang", imagebutton_guifu_huang);
		this.addRenderableWidget(imagebutton_guifu_huang);
	}
}
