
package net.mcreator.ceshi.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.ceshi.entity.QqiyuanJinGuangEntity;
import net.mcreator.ceshi.client.model.Modeljinguangshiti01_Converted_Converted;

public class QqiyuanJinGuangRenderer extends MobRenderer<QqiyuanJinGuangEntity, Modeljinguangshiti01_Converted_Converted<QqiyuanJinGuangEntity>> {
	public QqiyuanJinGuangRenderer(EntityRendererProvider.Context context) {
		super(context, new Modeljinguangshiti01_Converted_Converted<QqiyuanJinGuangEntity>(context.bakeLayer(Modeljinguangshiti01_Converted_Converted.LAYER_LOCATION)), 0.3f);
	}

	@Override
	public ResourceLocation getTextureLocation(QqiyuanJinGuangEntity entity) {
		return ResourceLocation.parse("primogemcraft:textures/entities/texture.png");
	}
}
