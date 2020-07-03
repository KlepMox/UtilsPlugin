package de.omamitrollator.utils.commands;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.omamitrollator.utils.main.Main;

public class VanishCommand implements CommandExecutor {
	
	static ArrayList<Player> vanish = new ArrayList<Player>();

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player) sender;
			if(p.hasPermission("util.vanish")) {
				if(command.getName().equalsIgnoreCase("vanish")) {
				if(vanish.contains(p)) {
					p.sendMessage("§cYou are not vanished anymore!");
					
					for(Player all : Bukkit.getOnlinePlayers()) {
						all.showPlayer(p);
					}
				}else {
					vanish.add(p);
					p.sendMessage("§aYou are now vanished!");
					
					for(Player all : Bukkit.getOnlinePlayers()) {
						all.hidePlayer(p);
					}
				}
					
					
				}
			}else
				p.sendMessage(Main.NO_PERMISSION);
		}else
			sender.sendMessage(Main.NO_CHAT_SENDER);
		return false;
	}

}
