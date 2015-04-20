package ygcommands.net.yougold.org.commands;

import org.bukkit.Material;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import ygcommands.net.yougold.org.Main;

public class Hat implements CommandExecutor {

	  private Main plugin;
	  
	  public Hat(Main plugin) {
	    this.plugin = plugin;
	  }
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
	{
		Player p = (Player) sender;
		if(plugin.getConfig().getBoolean("enabled.hat", true)) {
			if (cmd.getName().equalsIgnoreCase("hat")) {
				if(sender.hasPermission("yg.hat")) {
					if(p.getItemInHand().getType() == Material.AIR) {
						sender.sendMessage(ChatColor.DARK_RED + "You can't not set your hat to air!");
					} else if(!(p.getItemInHand().getType() == Material.AIR)) {
						ItemStack i = p.getInventory().getHelmet();
						Material m = p.getItemInHand().getType();
						i.setType(m);
						p.getInventory().setHelmet(i);
						p.getItemInHand().setType(Material.AIR);
					}
				}
			}
		}
		return false;
	}
}