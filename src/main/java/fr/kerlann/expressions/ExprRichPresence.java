package fr.kerlann.expressions;

import com.jagrosh.discordipc.entities.RichPresenceButton;
import fr.kerlann.SqRichPresence;
import fr.nico.sqript.expressions.ScriptExpression;
import fr.nico.sqript.meta.Expression;
import fr.nico.sqript.meta.Feature;
import fr.nico.sqript.structures.ScriptContext;
import fr.nico.sqript.structures.Side;
import fr.nico.sqript.types.ScriptType;
import fr.nico.sqript.types.TypeDictionary;
import fr.nico.sqript.types.primitive.TypeString;


@Expression(name = "RichPresence Expressions",
        features = {
                @Feature(name = "Manipulate Expressions", description = "Manipulate RichPresence", examples = "set ${sqRich} to RichPresence", pattern = "rich presence", type = "dictionary", side = Side.CLIENT),
        }
)
public class ExprRichPresence extends ScriptExpression {

    @Override
    public ScriptType get(ScriptContext context, ScriptType[] parameters) {
        return null;
    }

    @Override
    public boolean set(ScriptContext context, ScriptType to, ScriptType[] parameters) {
        switch(getMatchedIndex()){
            case 0:
                TypeDictionary dictionary = (TypeDictionary) to;
                TypeString details = (TypeString) dictionary.getObject().get(new TypeString("details"));
                TypeString state = (TypeString) dictionary.getObject().get(new TypeString("state"));
                TypeString largeImageKey = (TypeString) dictionary.getObject().get(new TypeString("largeImageKey"));
                TypeString largeImageText = (TypeString) dictionary.getObject().get(new TypeString("largeImageText"));
                TypeString smallImageKey = (TypeString) dictionary.getObject().get(new TypeString("smallImageKey"));
                TypeString smallImageText = (TypeString) dictionary.getObject().get(new TypeString("smallImageText"));
                TypeString firstButtonText = (TypeString) dictionary.getObject().get(new TypeString("firstButtonText"));
                TypeString firstButtonUrl = (TypeString) dictionary.getObject().get(new TypeString("firstButtonUrl"));
                TypeString secondButtonText = (TypeString) dictionary.getObject().get(new TypeString("secondButtonText"));
                TypeString secondButtonUrl = (TypeString) dictionary.getObject().get(new TypeString("secondButtonUrl"));
                RichPresenceButton[] discordButton = null;
                RichPresenceButton firstDiscordButton = null;
                RichPresenceButton secondDiscordButton = null;
                if(firstButtonText != null && firstButtonUrl != null) firstDiscordButton = new RichPresenceButton(firstButtonUrl.getObject(), firstButtonText.getObject());
                if(secondButtonText != null && secondButtonUrl != null) secondDiscordButton = new RichPresenceButton(secondButtonUrl.getObject(), secondButtonText.getObject());
                if(firstDiscordButton != null) discordButton = new RichPresenceButton[]{firstDiscordButton};
                if(firstDiscordButton != null && secondDiscordButton != null) discordButton = new RichPresenceButton[]{firstDiscordButton, secondDiscordButton};
                SqRichPresence.updatePresence(details.getObject(), state.getObject(), largeImageKey.getObject(), largeImageText.getObject(), smallImageKey.getObject(), smallImageText.getObject(), discordButton);
                return true;
        }
        return false;
    }
}
