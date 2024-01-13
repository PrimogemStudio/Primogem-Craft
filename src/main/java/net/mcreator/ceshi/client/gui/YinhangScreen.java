package net.mcreator.ceshi.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.ceshi.world.inventory.YinhangMenu;
import net.mcreator.ceshi.network.YinhangButtonMessage;
import net.mcreator.ceshi.PrimogemcraftMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class YinhangScreen extends AbstractContainerScreen<YinhangMenu> {
	private final static HashMap<String, Object> guistate = YinhangMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_cun_ru_zhe_xie;
	Button button_qing_ni_gun_kai;

	public YinhangScreen(YinhangMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("primogemcraft:textures/screens/yinhang.png");

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
		guiGraphics.drawString(this.font, Component.translatable("gui.primogemcraft.yinhang.label_cun_ru_yu_zhou_sui_pian_dang"), 47, 11, -6710887, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.primogemcraft.yinhang.label_xia_ci_yu_dao_shi_ke_ti"), 47, 21, -6710887, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.primogemcraft.yinhang.label_gong_xiang_ying_ping_zheng_bing_huo"), 47, 31, -6710887, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.primogemcraft.yinhang.label_de_shuang_bei_yu_zhou_sui_pian"), 47, 41, -6710887, false);
	}

	@Override
	public void onClose() {
		super.onClose();
	}

	@Override
	public void init() {
		super.init();
		button_cun_ru_zhe_xie = Button.builder(Component.translatable("gui.primogemcraft.yinhang.button_cun_ru_zhe_xie"), e -> {
			if (true) {
				PrimogemcraftMod.PACKET_HANDLER.sendToServer(new YinhangButtonMessage(0, x, y, z));
				YinhangButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 122, this.topPos + 28, 46, 20).build();
		guistate.put("button:button_cun_ru_zhe_xie", button_cun_ru_zhe_xie);
		this.addRenderableWidget(button_cun_ru_zhe_xie);
		button_qing_ni_gun_kai = Button.builder(Component.translatable("gui.primogemcraft.yinhang.button_qing_ni_gun_kai"), e -> {
			if (true) {
				PrimogemcraftMod.PACKET_HANDLER.sendToServer(new YinhangButtonMessage(1, x, y, z));
				YinhangButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}).bounds(this.leftPos + 122, this.topPos + 55, 46, 20).build();
		guistate.put("button:button_qing_ni_gun_kai", button_qing_ni_gun_kai);
		this.addRenderableWidget(button_qing_ni_gun_kai);
	}
}
