package de.omamitrollator.utils.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.omamitrollator.utils.main.Main;

public class DayCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player) sender;
			if(p.hasPermission("util.day")) {
				if(command.getName().equalsIgnoreCase("day")) {
					p.getWorld().setTime(1000);
					p.sendMessage("§aYou changed the time to Day!");
					return true;
				}
			}else
				p.sendMessage(Main.NO_PERMISSION);
		}else 
			sender.sendMessage(Main.NO_CHAT_SENDER);
		return false;
	}

}
