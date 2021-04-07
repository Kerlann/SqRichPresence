package fr.kerlann;

import com.jagrosh.discordipc.IPCClient;
import com.jagrosh.discordipc.entities.RichPresence;
import com.jagrosh.discordipc.entities.RichPresenceButton;
import com.jagrosh.discordipc.entities.pipe.PipeStatus;
import fr.kerlann.events.EventJoin;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLConstructionEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = "sqrichpresence", name = "SqRichPresence", version = "1.0.0")
public class SqRichPresence {

    public static long currentTime = System.currentTimeMillis();
    public static IPCClient client;

    @Mod.EventHandler
    public static void preInit(FMLConstructionEvent event) {
    }

    @Mod.EventHandler
    public static void preInit(FMLPreInitializationEvent event) {
        //ScriptManager.registerAction(ActRichPresence.class, "RichPresence Actions", new String[]{"init Discord RichPresence"}, new String[]{"initRichPresence \"discord bot id\""}, 0, Side.CLIENT, "initRichPresence {string}");
        //ScriptManager.registerExpression(ExprRichPresence.class, "RichPresence Expressions", new String[]{"Manipulate RichPresence"}, new String[]{"set data to RichPresence"}, 0, Side.CLIENT, "rich presence:dictionary");
        MinecraftForge.EVENT_BUS.register(new EventJoin());
    }

    public static void updatePresence(String details, String state, String largeImageKey, String largeImageText, String smallImageKey, String smallImageText, RichPresenceButton[] button) {
        if(client == null) return;
        RichPresence.Builder builder = new RichPresence.Builder();
        builder.setState(state)
            .setDetails(details)
            .setStartTimestamp(currentTime)
            .setLargeImage(largeImageKey, largeImageText)
            .setSmallImage(smallImageKey, smallImageText)
            .setButtons(button);
        if(client.getStatus().equals(PipeStatus.CONNECTED)) {
            client.sendRichPresence(builder.build());
        }
    }
}
