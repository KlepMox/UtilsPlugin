package de.omamitrollator.utils.commands;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import de.omamitrollator.utils.main.Main;

public class HeadCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player) sender;
			if(p.hasPermission("util.head")) {
				if(args.length == 1) {
					ItemStack itemStack = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
					SkullMeta im = (SkullMeta)itemStack.getItemMeta();
					im.setOwner(args[0]);
					im.setDisplayName(args[0]);
					itemStack.setItemMeta(im);
					p.getInventory().addItem(new ItemStack[] {itemStack});
					p.updateInventory();
					return true;
				}else
					p.sendMessage("§cPlease use /head <Playername>");
			}else
				p.sendMessage(Main.NO_PERMISSION);
		}else
			sender.sendMessage(Main.NO_CHAT_SENDER);
		return false;
	}

}
