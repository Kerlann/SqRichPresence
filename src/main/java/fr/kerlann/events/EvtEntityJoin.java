package fr.kerlann.events;


import fr.nico.sqript.events.ScriptEvent;
import fr.nico.sqript.meta.Event;
import fr.nico.sqript.structures.ScriptAccessor;
import fr.nico.sqript.types.TypePlayer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.eventhandler.Cancelable;

@Cancelable
@Event(name = "EntityJoinWorldEvent",
        description = "EntityJoinWorldEvent is fired when an Entity joins the world.",
        examples = "on entity join world event:",
        patterns = "entity join world event",
        accessors = "player:player")
public class EvtEntityJoin extends ScriptEvent {

    public EvtEntityJoin(EntityPlayer player) {
        super(new ScriptAccessor(new TypePlayer(player),"player"));
    }

}