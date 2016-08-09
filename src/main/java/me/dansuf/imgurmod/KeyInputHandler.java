package me.dansuf.imgurmod;

import java.awt.image.BufferedImage;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.util.ScreenShotHelper;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;

public class KeyInputHandler {
	
	KeyBinding screenShot;
	
	public KeyInputHandler(KeyBinding screenShot) {
		this.screenShot = screenShot;
	}
	
	
	@SubscribeEvent
	public void onKeyInput(InputEvent.KeyInputEvent event) {
		if(screenShot.isPressed()) {
			
			Minecraft mc = Minecraft.getMinecraft();
			
			BufferedImage img = ScreenShotHelper.createScreenshot(mc.displayWidth, mc.displayHeight, mc.getFramebuffer());
			
			Thread uploader = new Thread(new ImgUploader(img));
			uploader.start();
		}
	}
}
