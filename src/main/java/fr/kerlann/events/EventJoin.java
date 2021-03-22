package fr.kerlann.events;

import fr.nico.sqript.ScriptManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = "sqrichpresence")
public class EventJoin {

    @SubscribeEvent
    public void onEntityJoinWorldEvent(EntityJoinWorldEvent event){
        if(event.getEntity() instanceof EntityPlayer){
            if(ScriptManager.callEvent(new EvtEntityJoin((EntityPlayer) event.getEntity()))){
                event.setCanceled(true);
            }
        }
    }
}
