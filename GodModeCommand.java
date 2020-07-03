package de.omamitrollator.utils.commands;

import java.util.ArrayList;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.omamitrollator.utils.main.Main;

public class GodModeCommand implements CommandExecutor {
	
	public static ArrayList<Player> godmode = new ArrayList<Player>();

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player) sender;
			if(p.hasPermission("util.god")) {
				if(args.length == 0) {
				if(godmode.contains(p)) {
					godmode.remove(p);
					p.sendMessage("§aYou a not longer invincible!");
				}else
					godmode.add(p);
				p.sendMessage("§aYou are now invincible!");
				}else
					p.sendMessage("§cPlease use /godmode!");
			}else
				p.sendMessage(Main.NO_PERMISSION);
		}else
			sender.sendMessage(Main.NO_CHAT_SENDER);
		
		return false;
	}

}
