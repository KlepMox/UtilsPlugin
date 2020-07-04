package de.omamitrollator.utils.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_8_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;

import de.omamitrollator.utils.main.Main;
import net.minecraft.server.v1_8_R1.EntityPlayer;

public class PingCommand implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player) sender;
			if(args.length == 0) {
				p.sendMessage("§aYour ping is: §b " + getPing(p) + " §ams!");
			}else if(args.length == 1) {
				Player t = Bukkit.getPlayer(args[0]);
				if(t != null) {
					p.sendMessage("§aThe ping of the player §b" + args[0] + " §ais: §b" + getPing(t) + "§ams!");
				}else
					p.sendMessage(Main.NOT_ON_SERVER);
			}
			
		}else
			sender.sendMessage(Main.NO_CHAT_SENDER);
		return false;
	}
	
	public static Integer getPing(Player p) {
		CraftPlayer cp = (CraftPlayer) p;
		EntityPlayer ping = cp.getHandle();
		return ping.ping;
		
	}

}
