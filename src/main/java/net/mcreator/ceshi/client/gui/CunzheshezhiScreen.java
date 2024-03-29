package net.mcreator.ceshi.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.components.Checkbox;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.ceshi.world.inventory.CunzheshezhiMenu;
import net.mcreator.ceshi.network.CunzheshezhiButtonMessage;
import net.mcreator.ceshi.PrimogemcraftMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class CunzheshezhiScreen extends AbstractContainerScreen<CunzheshezhiMenu> {
	private final static HashMap<String, Object> guistate = CunzheshezhiMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	EditBox cunzhe_shuliang;
	Checkbox shifou_bwd;
	Button button_xie_ru;
	Button button_qing_ling;
	Button button_empty;

	public CunzheshezhiScreen(CunzheshezhiMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("primogemcraft:textures/screens/cunzheshezhi.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		cunzhe_shuliang.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
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
		if (cunzhe_shuliang.isFocused())
			return cunzhe_shuliang.keyPressed(key, b, c);
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
		cunzhe_shuliang.tick();
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
	}

	@Override
	public void onClose() {
		super.onClose();
	}

	@Override
	public void init() {
		super.init();
		cunzhe_shuliang = new EditBox(this.font, this.leftPos + 25, this.topPos + 52, 56, 18, Component.translatable("gui.primogemcraft.cunzheshezhi.cunzhe_shuliang")) {
			@Override
			public void insertText(String text) {
				super.insertText(text);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.primogemcraft.cunzheshezhi.cunzhe_shuliang").getString());
				else
					setSuggestion(null);
			}

			@Override
			public void moveCursorTo(int pos) {
				super.moveCursorTo(pos);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.primogemcraft.cunzheshezhi.cunzhe_shuliang").getString());
				else
					setSuggestion(null);
			}
		};
		cunzhe_shuliang.setSuggestion(Component.translatable("gui.primogemcraft.cunzheshezhi.cunzhe_shuliang").getString());
		cunzhe_shuliang.setMaxLength(32767);
		guistate.put("text:cunzhe_shuliang", cunzhe_shuliang);
		this.addWidget(this.cunzhe_shuliang);
		button_xie_ru = Button.builder(Component.translatable("gui.primogemcraft.cunzheshezhi.button_xie_ru"), e -> {
			if (true) {
				PrimogemcraftMod.PACKET_HANDLER.sendToServer(new CunzheshezhiButtonMessage(0, x, y, z));
				CunzheshezhiButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 84, this.topPos + 51, 35, 20).build();
		guistate.put("button:button_xie_ru", button_xie_ru);
		this.addRenderableWidget(button_xie_ru);
		button_qing_ling = Button.builder(Component.translatable("gui.primogemcraft.cunzheshezhi.button_qing_ling"), e -> {
			if (true) {
				PrimogemcraftMod.PACKET_HANDLER.sendToServer(new CunzheshezhiButtonMessage(1, x, y, z));
				CunzheshezhiButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}).bounds(this.leftPos + 123, this.topPos + 51, 35, 20).build();
		guistate.put("button:button_qing_ling", button_qing_ling);
		this.addRenderableWidget(button_qing_ling);
		button_empty = Button.builder(Component.translatable("gui.primogemcraft.cunzheshezhi.button_empty"), e -> {
			if (true) {
				PrimogemcraftMod.PACKET_HANDLER.sendToServer(new CunzheshezhiButtonMessage(2, x, y, z));
				CunzheshezhiButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}).bounds(this.leftPos + 22, this.topPos + 23, 10, 20).build();
		guistate.put("button:button_empty", button_empty);
		this.addRenderableWidget(button_empty);
		shifou_bwd = new Checkbox(this.leftPos + 71, this.topPos + 22, 20, 20, Component.translatable("gui.primogemcraft.cunzheshezhi.shifou_bwd"), false);
		guistate.put("checkbox:shifou_bwd", shifou_bwd);
		this.addRenderableWidget(shifou_bwd);
	}
}
