package ygcommands.net.yougold.org.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import ygcommands.net.yougold.org.Main;

public class Ban implements CommandExecutor {

	  private Main plugin;
	  
	  public Ban(Main plugin) {
	    this.plugin = plugin;
	  }
	
	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
	{
		Player p = (Player) sender;
		if(plugin.getConfig().getBoolean("enabled.ban", true)) {
			if (cmd.getName().equalsIgnoreCase("ban")) {
				if(args.length < 2){
					sender.sendMessage(ChatColor.RED + "Try /ban <Player> <reason>");
					return true;
				}

				if (sender.hasPermission("yg.ban")) {
					Player target = (Bukkit.getServer().getPlayer(args[0]));
					if (target == null) {
						sender.sendMessage(args[0] + " is not online!");
						return true;
					} else {
						target.setBanned(true);
						Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', args[1]));
						String KickMessage = ChatColor.translateAlternateColorCodes('&', (String)plugin.getConfig().getString("player-ban-message").replace("%player", target.getName().toString()).replace("%reason", args[1].toString()));
						target.kickPlayer(KickMessage);
						p.sendMessage(ChatColor.DARK_PURPLE + "You have banned " + target.getName() + " with the reason of: " + args[1]);
					}
				}
			}
		}
		return false;
	}
}