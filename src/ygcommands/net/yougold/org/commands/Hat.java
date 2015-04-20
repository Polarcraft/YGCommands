package ygcommands.net.yougold.org.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

import ygcommands.net.yougold.org.Main;

public class Hat implements CommandExecutor {

	  private Main plugin;
	  
	  public Hat(Main plugin) {
	    this.plugin = plugin;
	  }
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
	{
		Player p = (Player) sender;
		if(plugin.getConfig().getBoolean("enabled.hat") == true) {
			if (cmd.getName().equalsIgnoreCase("hat")) {
				if(sender.hasPermission("yg.hat")) {
					PlayerInventory inv = p.getInventory();
					ItemStack hand = p.getItemInHand();
					if(inv.getHelmet() != null) {
						inv.addItem(new ItemStack[] { inv.getHelmet() });
					}
					inv.setHelmet(hand);
					inv.remove(hand);
					p.sendMessage("Your helmet has been set!");
				} else {
					p.sendMessage("You do not have permission to execute this command!");
				}
			}
		}
		return false;
	}
}