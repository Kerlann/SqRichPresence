package fr.kerlann.actions;

import com.jagrosh.discordipc.IPCClient;
import com.jagrosh.discordipc.IPCListener;
import com.jagrosh.discordipc.entities.pipe.PipeStatus;
import com.jagrosh.discordipc.exceptions.NoDiscordClientException;
import fr.kerlann.SqRichPresence;
import fr.nico.sqript.actions.ScriptAction;
import fr.nico.sqript.compiling.ScriptException;
import fr.nico.sqript.expressions.ScriptExpression;
import fr.nico.sqript.meta.Action;
import fr.nico.sqript.meta.Feature;
import fr.nico.sqript.structures.ScriptContext;
import fr.nico.sqript.structures.Side;

import java.sql.SQLOutput;

@Action(name = "RichPresence Actions",
        features = {
                @Feature(name = "RichPresence Actions", description = "Initialize Discord RichPresence", examples = "initRichPresence (discord bot id)", pattern = "initRichPresence {string}", side = Side.CLIENT),
        }
)
public class ActRichPresence extends ScriptAction {

    @Override
    public void execute(ScriptContext scriptContext) throws ScriptException {
        System.out.println(SqRichPresence.client);
        System.out.println("initatia");
        if (SqRichPresence.client == null){
            ScriptExpression firstParameter = getParameters().get(0);
            String value = firstParameter.get(scriptContext).toString();
            SqRichPresence.client = new IPCClient(Long.parseLong(value));
            SqRichPresence.client.setListener(new IPCListener() {
                @Override
                public void onReady(IPCClient client) {}
            });
            System.out.println(SqRichPresence.client);
            try {
                if(!SqRichPresence.client.getStatus().equals(PipeStatus.CONNECTED)){
                    SqRichPresence.client.connect();
                    System.out.println(SqRichPresence.client);
                }
            } catch (NoDiscordClientException e) {
                e.printStackTrace();
            }
        }
    }
}
