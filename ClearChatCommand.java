package de.omamitrollator.utils.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import org.bukkit.entity.Player;

import de.omamitrollator.utils.main.Main;


public class ClearChatCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player) sender;
			if(p.hasPermission("util.chatclear")) {
				if(args.length == 0) {
					for(int i = 0; i <= 200; i++) {
						Bukkit.broadcastMessage(" ");
					}
					Bukkit.broadcastMessage("§aThe chat was cleared by §b" + p.getName() + " §a!");
				}
			}else
				p.sendMessage(Main.NO_PERMISSION);
			
		}else
			sender.sendMessage(Main.NO_CHAT_SENDER);
		return false;
	}

}
