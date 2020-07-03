package de.omamitrollator.utils.commands;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.omamitrollator.utils.main.Main;

public class GMCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player) sender; 
			if(p.hasPermission("util.gm")) {
				if(args.length == 1) {
					if(args[0].equals("0")) {
						p.setGameMode(GameMode.SURVIVAL);
						p.sendMessage("§aYou are now in the Survival mode!");
					}else if(args[0].equals("1")) {
						p.setGameMode(GameMode.CREATIVE);
						p.sendMessage("§aYou are now in the Creative mode!");
					}else if(args[0].equals("2")) {
						p.setGameMode(GameMode.ADVENTURE);
						p.sendMessage("§aYou are now in the Adventure mode!");
					}else if(args[0].equals("3")) {
						p.setGameMode(GameMode.SPECTATOR);
						p.sendMessage("§aYou are now in the Spectator mode!");
					}
					
				}else if(args.length == 2) {
					Player t = Bukkit.getPlayer(args[1]);
					if(t != null) {
						if(args[0].equals("0")) {
							t.setGameMode(GameMode.SURVIVAL);
							t.sendMessage("§aYou are now in the Survival mode!");
							p.sendMessage("§aYou set §b" + args[1] + "§a in the Survival mode!");
						}else if(args[0].equals("1")) {
							t.setGameMode(GameMode.CREATIVE);
							t.sendMessage("§aYou are now in the Creative mode!");
							p.sendMessage("§aYou set §b" + args[1] + "§a in the Creative mode!");
						}else if(args[0].equals("2")) {
							t.setGameMode(GameMode.ADVENTURE);
							t.sendMessage("§aYou are now in the Adventure mode!");
							p.sendMessage("§aYou set §b" + args[1] + "§a in the Adventure mode!");
						}else if(args[0].equals("3")) {
							t.setGameMode(GameMode.SPECTATOR);
							t.sendMessage("§aYou are now in the Spectator mode!");
							p.sendMessage("§aYou set §b" + args[1] + "§a in the Spectator mode!");
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
