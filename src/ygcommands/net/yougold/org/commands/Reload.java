package ygcommands.net.yougold.org.commands;

import net.md_5.bungee.api.ChatColor;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import ygcommands.net.yougold.org.Main;

public class Reload implements CommandExecutor {

	  private Main plugin;
	  
	  public Reload(Main plugin) {
	    this.plugin = plugin;
	  }
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
	{
		if(cmd.getName().equalsIgnoreCase("yg")) {
			if (args.length == 0) {
				if(sender.hasPermission("yg")) {
					String message1 = ChatColor.translateAlternateColorCodes('&', "&4&l[&cYGCommands&4&l]&f &6/yg reload - This commands will reload the configuration!");
					sender.sendMessage(message1);
				} else {
					sender.sendMessage(ChatColor.DARK_RED + "You do not have permission to execute this command!");
				}
			} else if(args.length == 1) {
				if(args[0].equalsIgnoreCase("reload")) {
					plugin.reloadConfig();
					String message1 = ChatColor.translateAlternateColorCodes('&', "&4&l[&cYGCommands&4&l]&f &2Has been reloaded from disk!");
					sender.sendMessage(message1);
				}
			}
		}
		return false;
	}
}
