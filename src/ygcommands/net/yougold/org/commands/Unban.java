package ygcommands.net.yougold.org.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import ygcommands.net.yougold.org.Main;

public class Unban implements CommandExecutor {

	  private Main plugin;
	  
	  public Unban(Main plugin) {
	    this.plugin = plugin;
	  }
	
	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
	{
		Player p = (Player) sender;
		if (plugin.getConfig().getBoolean("enabled.unban") == true) {
			if (cmd.getName().equalsIgnoreCase("unban")) {
				if(args.length < 1){
					sender.sendMessage(ChatColor.RED + "Try /unban <Player>");
					return true;
				}

				if (sender.hasPermission("yg.unban")) {
					OfflinePlayer target = (Bukkit.getServer().getOfflinePlayer(args[0]));
					if (!target.isBanned()) {
						sender.sendMessage(args[0] + " is not banned!");
						return true;
					} else {
						target.setBanned(false);
						String UnbanMessage = ChatColor.translateAlternateColorCodes('&', (String)plugin.getConfig().getString("player-unban-message").replace("%player", target.getName().toString()).replace("%sender", sender.toString()));
						Bukkit.broadcastMessage(UnbanMessage);
						p.sendMessage(ChatColor.DARK_PURPLE + "You have unbanned " + target.getName() + "!");
					}
				}
			}
		}
		return false;
	}
}