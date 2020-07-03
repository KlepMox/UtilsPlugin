package de.omamitrollator.utils.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.omamitrollator.utils.main.Main;

public class HealCommand implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player) sender;
			if(p.hasPermission("util.heal")) {
				if(args.length == 0) {
					p.setHealth(20);
					p.setFoodLevel(20);
					p.sendMessage("§aYou were healed!");
				}else if(args.length == 1) {
					Player t = Bukkit.getPlayer(args[0]);
					if(t != null) {
					t.setHealth(20);
					t.setFoodLevel(20);
					t.sendMessage("§aYou were healed!");
					p.sendMessage("§aYou healed the Player: §b" + args[0] + "§a!");
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
