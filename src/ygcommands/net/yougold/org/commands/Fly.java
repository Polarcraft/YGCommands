package ygcommands.net.yougold.org.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import ygcommands.net.yougold.org.Main;

public class Fly implements CommandExecutor {
	
	  private Main plugin;
	  
	  public Fly(Main plugin) {
	    this.plugin = plugin;
	  }
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
	{
		Player p = (Player) sender;
		if(plugin.getConfig().getBoolean("enabled.fly", true)) {
			if (cmd.getName().equalsIgnoreCase("fly")) {
				if(args.length < 1){
					sender.sendMessage(ChatColor.RED + "Try /fly <player>");
					return true;
				}

				if (sender.hasPermission("yg.fly")) {
					Player target = (Bukkit.getServer().getPlayer(args[0]));
					if (target == null) {
						sender.sendMessage(args[0] + " is not online!");
						return true;
					} else {
						if(target.isFlying()) {
							target.setAllowFlight(false);
							target.setFlying(false);
							p.sendMessage(ChatColor.DARK_PURPLE.toString() + ChatColor.BOLD + "Fly toggled for: " + target.getName());
							target.sendMessage(ChatColor.DARK_PURPLE.toString() + ChatColor.BOLD + "Fly now " + ChatColor.DARK_RED + "disabled!");
						} 
						else if (!target.isFlying()) {
							target.setAllowFlight(true);
							target.setFlying(true);
							p.sendMessage(ChatColor.DARK_PURPLE.toString() + ChatColor.BOLD + "Fly toggled for: " + target.getName());
							target.sendMessage(ChatColor.DARK_PURPLE.toString() + ChatColor.BOLD + "Fly now " + ChatColor.DARK_GREEN + "enabled!");
						}
					}
				}
			}
		}
		return false;
	}
}