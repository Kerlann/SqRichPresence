package fr.kerlann;

import com.jagrosh.discordipc.IPCClient;
import com.jagrosh.discordipc.entities.RichPresence;
import com.jagrosh.discordipc.entities.RichPresenceButton;
import com.jagrosh.discordipc.entities.pipe.PipeStatus;
import fr.nico.sqript.addons.SqriptAddon;

@SqriptAddon(name = "SqRichPresence", version = "1.0")
public class SqRichPresence {

    public static long currentTime = System.currentTimeMillis();
    public static IPCClient client;

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

    public static void onLoad(){
        System.out.println("INITIALISAIOFJKLDGJDGKLFjgjkldgkhlddlkjnhkflnjklgfkljlkcngfklfnjklfg,nkd,mkbnpdpbkhn");
    }
}
