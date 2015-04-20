package ygcommands.net.yougold.org.events;

import net.md_5.bungee.api.ChatColor;

import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.EventHandler;

import ygcommands.net.yougold.org.Main;

public class Cursing implements Listener {

	  private Main plugin;
	  
	  public Cursing(Main plugin) {
	    this.plugin = plugin;
	  }
	
	@EventHandler
	public void onPlayerChat(AsyncPlayerChatEvent e) {
		if(plugin.getConfig().getBoolean("enabled.anticursing", true)) {
			for(String word : e.getMessage().split(" ")) {
				if(plugin.getConfig().getStringList("cursewords").contains(word)) {
					e.setCancelled(true);
					String prefix = (ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("messages.anticurse-prefix")));
					String cursemessage = (ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("messages.cursemessage")));
					e.getPlayer().sendMessage(prefix + " " + cursemessage);
				}
			}
		}
	}
}
