package ygcommands.net.yougold.org.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import ygcommands.net.yougold.org.Main;

public class Kick implements CommandExecutor {

	  private Main plugin;
	  
	  public Kick(Main plugin) {
	    this.plugin = plugin;
	  }
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
	{
		Player p = (Player) sender;
		if(plugin.getConfig().getBoolean("enabled.kick", true)) {
			if (cmd.getName().equalsIgnoreCase("kick")) {
				if(args.length < 2){
					sender.sendMessage(ChatColor.RED + "Try /kick <Player> <reason>");
					return true;
				}

				if (sender.hasPermission("yg.kick")) {
					Player target = (Bukkit.getServer().getPlayer(args[0]));
					if (target == null) {
						sender.sendMessage(args[0] + " is not online!");
						return true;
					} else {
						String KickMessage = ChatColor.translateAlternateColorCodes('&', (String)plugin.getConfig().getString("player-kick-message").replace("%player", p.getName().toString()).replace("%reason", args[1].toString()));
						target.kickPlayer(KickMessage);
						p.sendMessage(ChatColor.DARK_PURPLE + "You have kicked " + target.getName() + " with the reason of: " + args[1]);
					}
				}
			}
		}
		return false;
	}
}