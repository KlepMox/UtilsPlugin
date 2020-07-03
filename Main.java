package de.omamitrollator.utils.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import de.omamitrollator.utils.Listener.GodModeListener;
import de.omamitrollator.utils.commands.ClearChatCommand;
import de.omamitrollator.utils.commands.DayCommand;
import de.omamitrollator.utils.commands.FlyCommand;
import de.omamitrollator.utils.commands.GMCommand;
import de.omamitrollator.utils.commands.GodModeCommand;
import de.omamitrollator.utils.commands.HeadCommand;
import de.omamitrollator.utils.commands.HealCommand;
import de.omamitrollator.utils.commands.NightCommand;
import de.omamitrollator.utils.commands.SpeedCommand;
import de.omamitrollator.utils.commands.VanishCommand;

public class Main extends JavaPlugin{ 
	
	//*Author OmaMitRollator*\\
	public static String NO_PERMISSION = "§cYou dont have the Permission to execute this Command!";
	public static String NO_CHAT_SENDER = "§cPlayer only Command!";
	public static String NOT_ON_SERVER = "§cThis Player is not on this Server!!";
	
	
	@Override
	public void onLoad() {
		Bukkit.getConsoleSender().sendMessage("Plugin by OmaMitRollator");
	}
	
	@Override
	public void onEnable() {
		getCommand("heal").setExecutor(new HealCommand());
		getCommand("fly").setExecutor(new FlyCommand());
		getCommand("day").setExecutor(new DayCommand());
		getCommand("night").setExecutor(new NightCommand());
		getCommand("cc").setExecutor(new ClearChatCommand());
		getCommand("vanish").setExecutor(new VanishCommand());
		getCommand("gm").setExecutor(new GMCommand());
		getCommand("speed").setExecutor(new SpeedCommand());
		getCommand("head").setExecutor(new HeadCommand());
		getCommand("godmode").setExecutor(new GodModeCommand());
		
		PluginManager plm = Bukkit.getPluginManager();
		plm.registerEvents(new GodModeListener(), this);
	}
	
	@Override
	public void onDisable() {

	}
	

}
