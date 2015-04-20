package ygcommands.net.yougold.org;

import org.bukkit.plugin.java.JavaPlugin;

import ygcommands.net.yougold.org.commands.Ban;
import ygcommands.net.yougold.org.commands.Fly;
import ygcommands.net.yougold.org.commands.Hat;
import ygcommands.net.yougold.org.commands.Kick;
import ygcommands.net.yougold.org.commands.Unban;
import ygcommands.net.yougold.org.events.Cursing;

public class Main extends JavaPlugin {
	
	public void onEnable() {
		getCommand("ban").setExecutor(new Ban(this));
		getCommand("fly").setExecutor(new Fly(this));
		getCommand("hat").setExecutor(new Hat(this));
		getCommand("kick").setExecutor(new Kick(this));
		getCommand("unban").setExecutor(new Unban(this));
		getServer().getPluginManager().registerEvents(new Cursing(this), this);
		getConfig().options().copyDefaults(true);
		saveConfig();
	}
}
