package net.mcreator.ceshi.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.components.EditBox;
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
	Button button_empty;
	Button button_10;
	Button button_100;
	Button button_1000;
	Button button_11;
	Button button_101;
	Button button_1001;
	Button button_empty1;
	Button button_empty2;
	Button button_empty3;
	ImageButton imagebutton_cuo;

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
		if (mouseX > leftPos + 115 && mouseX < leftPos + 128 && mouseY > topPos + 35 && mouseY < topPos + 55)
			guiGraphics.renderTooltip(font, Component.translatable("gui.primogemcraft.cunzheshezhi.tooltip_shi_shu_liang_zeng_jia"), mouseX, mouseY);
		if (mouseX > leftPos + 131 && mouseX < leftPos + 142 && mouseY > topPos + 35 && mouseY < topPos + 55)
			guiGraphics.renderTooltip(font, Component.translatable("gui.primogemcraft.cunzheshezhi.tooltip_shi_shu_liang_jian_shao"), mouseX, mouseY);
		if (mouseX > leftPos + 68 && mouseX < leftPos + 87 && mouseY > topPos + 13 && mouseY < topPos + 32)
			guiGraphics.renderTooltip(font, Component.translatable("gui.primogemcraft.cunzheshezhi.tooltip_qu_chu_shi_you_gu_ding_shu_liang_zhuan_bian_wei_0240"), mouseX, mouseY);
		if (mouseX > leftPos + 66 && mouseX < leftPos + 111 && mouseY > topPos + 36 && mouseY < topPos + 54)
			guiGraphics.renderTooltip(font, Component.translatable("gui.primogemcraft.cunzheshezhi.tooltip_cong_xia_fang_an_niu_shu_ru"), mouseX, mouseY);
		if (mouseX > leftPos + 22 && mouseX < leftPos + 32 && mouseY > topPos + 14 && mouseY < topPos + 34)
			guiGraphics.renderTooltip(font, Component.translatable("gui.primogemcraft.cunzheshezhi.tooltip_fang_ru_bei_bao"), mouseX, mouseY);
		if (mouseX > leftPos + 31 && mouseX < leftPos + 52 && mouseY > topPos + 35 && mouseY < topPos + 57)
			guiGraphics.renderTooltip(font, Component.translatable("gui.primogemcraft.cunzheshezhi.tooltip_ssczhong_zhi_she_ding_shu_liang_he_ping_zheng"), mouseX, mouseY);
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
		guiGraphics.drawString(this.font, Component.translatable("gui.primogemcraft.cunzheshezhi.label_empty"), 89, 66, -10066330, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.primogemcraft.cunzheshezhi.label_empty1"), 79, 66, -10066330, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.primogemcraft.cunzheshezhi.label_qi_yong_guan_bi_bu_wen_ding"), 88, 18, -3407872, false);
	}

	@Override
	public void init() {
		super.init();
		cunzhe_shuliang = new EditBox(this.font, this.leftPos + 66, this.topPos + 36, 45, 18, Component.translatable("gui.primogemcraft.cunzheshezhi.cunzhe_shuliang")) {
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
		button_empty = Button.builder(Component.translatable("gui.primogemcraft.cunzheshezhi.button_empty"), e -> {
			if (true) {
				PrimogemcraftMod.PACKET_HANDLER.sendToServer(new CunzheshezhiButtonMessage(0, x, y, z));
				CunzheshezhiButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 22, this.topPos + 14, 10, 20).build();
		guistate.put("button:button_empty", button_empty);
		this.addRenderableWidget(button_empty);
		button_10 = Button.builder(Component.translatable("gui.primogemcraft.cunzheshezhi.button_10"), e -> {
			if (true) {
				PrimogemcraftMod.PACKET_HANDLER.sendToServer(new CunzheshezhiButtonMessage(1, x, y, z));
				CunzheshezhiButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}).bounds(this.leftPos + 97, this.topPos + 61, 14, 20).build();
		guistate.put("button:button_10", button_10);
		this.addRenderableWidget(button_10);
		button_100 = Button.builder(Component.translatable("gui.primogemcraft.cunzheshezhi.button_100"), e -> {
			if (true) {
				PrimogemcraftMod.PACKET_HANDLER.sendToServer(new CunzheshezhiButtonMessage(2, x, y, z));
				CunzheshezhiButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}).bounds(this.leftPos + 113, this.topPos + 61, 17, 20).build();
		guistate.put("button:button_100", button_100);
		this.addRenderableWidget(button_100);
		button_1000 = Button.builder(Component.translatable("gui.primogemcraft.cunzheshezhi.button_1000"), e -> {
			if (true) {
				PrimogemcraftMod.PACKET_HANDLER.sendToServer(new CunzheshezhiButtonMessage(3, x, y, z));
				CunzheshezhiButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		}).bounds(this.leftPos + 132, this.topPos + 61, 23, 20).build();
		guistate.put("button:button_1000", button_1000);
		this.addRenderableWidget(button_1000);
		button_11 = Button.builder(Component.translatable("gui.primogemcraft.cunzheshezhi.button_11"), e -> {
			if (true) {
				PrimogemcraftMod.PACKET_HANDLER.sendToServer(new CunzheshezhiButtonMessage(4, x, y, z));
				CunzheshezhiButtonMessage.handleButtonAction(entity, 4, x, y, z);
			}
		}).bounds(this.leftPos + 65, this.topPos + 61, 13, 20).build();
		guistate.put("button:button_11", button_11);
		this.addRenderableWidget(button_11);
		button_101 = Button.builder(Component.translatable("gui.primogemcraft.cunzheshezhi.button_101"), e -> {
			if (true) {
				PrimogemcraftMod.PACKET_HANDLER.sendToServer(new CunzheshezhiButtonMessage(5, x, y, z));
				CunzheshezhiButtonMessage.handleButtonAction(entity, 5, x, y, z);
			}
		}).bounds(this.leftPos + 47, this.topPos + 61, 16, 20).build();
		guistate.put("button:button_101", button_101);
		this.addRenderableWidget(button_101);
		button_1001 = Button.builder(Component.translatable("gui.primogemcraft.cunzheshezhi.button_1001"), e -> {
			if (true) {
				PrimogemcraftMod.PACKET_HANDLER.sendToServer(new CunzheshezhiButtonMessage(6, x, y, z));
				CunzheshezhiButtonMessage.handleButtonAction(entity, 6, x, y, z);
			}
		}).bounds(this.leftPos + 22, this.topPos + 61, 23, 20).build();
		guistate.put("button:button_1001", button_1001);
		this.addRenderableWidget(button_1001);
		button_empty1 = Button.builder(Component.translatable("gui.primogemcraft.cunzheshezhi.button_empty1"), e -> {
			if (true) {
				PrimogemcraftMod.PACKET_HANDLER.sendToServer(new CunzheshezhiButtonMessage(7, x, y, z));
				CunzheshezhiButtonMessage.handleButtonAction(entity, 7, x, y, z);
			}
		}).bounds(this.leftPos + 115, this.topPos + 35, 12, 20).build();
		guistate.put("button:button_empty1", button_empty1);
		this.addRenderableWidget(button_empty1);
		button_empty2 = Button.builder(Component.translatable("gui.primogemcraft.cunzheshezhi.button_empty2"), e -> {
			if (true) {
				PrimogemcraftMod.PACKET_HANDLER.sendToServer(new CunzheshezhiButtonMessage(8, x, y, z));
				CunzheshezhiButtonMessage.handleButtonAction(entity, 8, x, y, z);
			}
		}).bounds(this.leftPos + 130, this.topPos + 35, 12, 20).build();
		guistate.put("button:button_empty2", button_empty2);
		this.addRenderableWidget(button_empty2);
		button_empty3 = Button.builder(Component.translatable("gui.primogemcraft.cunzheshezhi.button_empty3"), e -> {
			if (true) {
				PrimogemcraftMod.PACKET_HANDLER.sendToServer(new CunzheshezhiButtonMessage(9, x, y, z));
				CunzheshezhiButtonMessage.handleButtonAction(entity, 9, x, y, z);
			}
		}).bounds(this.leftPos + 68, this.topPos + 13, 19, 20).build();
		guistate.put("button:button_empty3", button_empty3);
		this.addRenderableWidget(button_empty3);
		imagebutton_cuo = new ImageButton(this.leftPos + 31, this.topPos + 35, 21, 21, 0, 0, 21, new ResourceLocation("primogemcraft:textures/screens/atlas/imagebutton_cuo.png"), 21, 42, e -> {
			if (true) {
				PrimogemcraftMod.PACKET_HANDLER.sendToServer(new CunzheshezhiButtonMessage(10, x, y, z));
				CunzheshezhiButtonMessage.handleButtonAction(entity, 10, x, y, z);
			}
		});
		guistate.put("button:imagebutton_cuo", imagebutton_cuo);
		this.addRenderableWidget(imagebutton_cuo);
	}
}
