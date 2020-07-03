package de.omamitrollator.utils.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.omamitrollator.utils.main.Main;

public class FlyCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player) sender;
			if(p.hasPermission("util.fly")) {
				if(args.length == 0) {
					if(p.getAllowFlight()) {
						p.setAllowFlight(false);
						p.sendMessage("§cYou can not fly anymore!");
					}else {
						p.setAllowFlight(true);
						p.sendMessage("§aYou can fly now!");
					}
				}else if(args.length == 1) {
					Player t = Bukkit.getPlayer(args[0]);
					if(t != null) {
						if(t.getAllowFlight()) {
							t.setAllowFlight(false);
							t.sendMessage("§cYou can not fly anymore!");
							p.sendMessage("§cYou took the player §b" + args[0] + " §aout of the flight mode");
						}else {
							t.setAllowFlight(true);
							t.sendMessage("§aYou can fly now!");
							p.sendMessage("§aYou set the player §b" + args[0] + "§ain the flight mode");
						}
					}else
						p.sendMessage(Main.NOT_ON_SERVER);
				}
			}else
				p.sendMessage(Main.NO_PERMISSION);
		}else
			sender.sendMessage(Main.NO_CHAT_SENDER);
		return false;
	}

}
