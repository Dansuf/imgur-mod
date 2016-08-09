package me.dansuf.imgurmod;

import org.lwjgl.input.Keyboard;

import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = ImgurMod.MODID, version = ImgurMod.VERSION)
public class ImgurMod {
    public static final String MODID = "dansuf_imgurmod";
    public static final String VERSION = "1.0-1.10.2";
    public static KeyBinding screenShot;
    
    @Instance
    public static ImgurMod instance = new ImgurMod();
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent e) {
    	screenShot = new KeyBinding("key.imgurshot", Keyboard.KEY_F10, "key.categories.imgurmod");
    	MinecraftForge.EVENT_BUS.register(new KeyInputHandler(screenShot));
    }
    
    @EventHandler
    public void init(FMLInitializationEvent event) {
        ClientRegistry.registerKeyBinding(screenShot);
    }
}
