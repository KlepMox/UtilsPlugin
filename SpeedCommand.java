package de.omamitrollator.utils.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.omamitrollator.utils.main.Main;

public class SpeedCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player) sender;
			if(p.hasPermission("util.speed")) {
				if(args.length == 0) {
					p.sendMessage("§cPlease use /speed <1-10>!");
				}else if(args.length == 1) {
					int speed;
					try {
						speed = Integer.parseInt(args[0]);
					} catch (NumberFormatException e1) {
						p.sendMessage("§cPlease use /speed <1-10>!");
						return false;
					} 
					if(speed < 1 || speed > 10) {
						p.sendMessage("§cPlease use /speed <1-10>!");
						return false;
					}
					if(p.isFlying()) {
						p.setFlySpeed((float) speed / 10);
					}else {
						p.setWalkSpeed((float) speed / 10);
					}
					p.sendMessage("§aYou are now on speed §b" + speed + "§a!");
				}
				
			}else
				p.sendMessage(Main.NO_PERMISSION);
		}else
			sender.sendMessage(Main.NO_CHAT_SENDER);
		return false;
	}

}
