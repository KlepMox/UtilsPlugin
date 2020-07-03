package de.omamitrollator.utils.Listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

import de.omamitrollator.utils.commands.GodModeCommand;

public class GodModeListener implements Listener{
	
	@EventHandler
	public void onDamage(EntityDamageEvent e) {
		Player p = (Player) e.getEntity();
		
		if(GodModeCommand.godmode.contains(p)) {
			e.setCancelled(true);
		}else {
			e.setCancelled(false);
		}
			
	}

}
