package ygcommands.net.yougold.org.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import ygcommands.net.yougold.org.Main;

public class Gamemode implements CommandExecutor {

	  private Main plugin;
	  
	  public Gamemode(Main plugin) {
	    this.plugin = plugin;
	  }
	
		public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
		{
			Player p = (Player) sender;
			if(plugin.getConfig().getBoolean("enabled.gamemode") == true) {
				if(cmd.getName().equalsIgnoreCase("gm")) {
					if(args.length == 0) {
						if(sender.hasPermission("pcb")) {
							sender.sendMessage("Invalid try /gm <gamemode>");
						} else {
							sender.sendMessage(ChatColor.DARK_RED + "Nice try!");
						}
					} else if (args.length == 1) {
						if(args[0].equalsIgnoreCase("0") || (args[0].equalsIgnoreCase("survival")) || (args[0].equalsIgnoreCase("s"))) {
							if(sender.hasPermission("yg.gm")) {
								p.setGameMode(GameMode.SURVIVAL);
								String message = ChatColor.translateAlternateColorCodes('&', "&4&l[&cYGCommands&4&l]&f &2Your gamemode has been set to survival!");
								sender.sendMessage(message);
							} else {
								sender.sendMessage(ChatColor.DARK_RED + "Nice Try!");
							}
						} else if(args[0].equalsIgnoreCase("1") || (args[0].equalsIgnoreCase("creative")) || (args[0].equalsIgnoreCase("c"))) {
							if(sender.hasPermission("yg.gm")) {
								p.setGameMode(GameMode.CREATIVE);
								String message1 = ChatColor.translateAlternateColorCodes('&', "&4&l[&cYGCommands&4&l]&f &2Your gamemode has been set to creative!");
								sender.sendMessage(message1);
							} else {
								sender.sendMessage(ChatColor.DARK_RED + "Nice Try!");
							}
						} else if (args.length == 2) {
							if(sender.hasPermission("yg.gm")) {
								Player target = (Bukkit.getServer().getPlayer(args[1]));
								if (target == null) {
									sender.sendMessage(args[1] + " is not online!");
									return true;
								} else {
									if(args[0].equalsIgnoreCase("0") || (args[0].equalsIgnoreCase("survival")) || (args[0].equalsIgnoreCase("s"))) {
										target.setGameMode(GameMode.SURVIVAL);
										String message = ChatColor.translateAlternateColorCodes('&', "&4&l[&cYGCommands&4&l]&f &2Your gamemode has been set to survival!");
										target.sendMessage(message);
									} else {
										sender.sendMessage(ChatColor.DARK_RED + "Nice Try!");
									}
								}
							} else if(args[0].equalsIgnoreCase("1") || (args[0].equalsIgnoreCase("creative")) || (args[0].equalsIgnoreCase("c"))) {
								if(sender.hasPermission("yg.gm")) {
									p.setGameMode(GameMode.CREATIVE);
									String message1 = ChatColor.translateAlternateColorCodes('&', "&4&l[&cYGCommands&4&l]&f &2Your gamemode has been set to creative!");
									sender.sendMessage(message1);
								} else {
									sender.sendMessage(ChatColor.DARK_RED + "Nice Try!");
								}
							}
						} else if(args.length >= 2) {
							sender.sendMessage("TOO MANY ARGUMENTS");
						}
					}
				}
			}
			return false;
		}
}