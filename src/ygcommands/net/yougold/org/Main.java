package ygcommands.net.yougold.org;

import org.bukkit.plugin.java.JavaPlugin;

import ygcommands.net.yougold.org.commands.*;
import ygcommands.net.yougold.org.events.Cursing;

public class Main extends JavaPlugin {
	
	public void onEnable() {
		getCommand("ban").setExecutor(new Ban(this));
		getCommand("fly").setExecutor(new Fly(this));
		getCommand("hat").setExecutor(new Hat(this));
		getCommand("kick").setExecutor(new Kick(this));
		getCommand("gm").setExecutor(new Gamemode(this));
		getCommand("unban").setExecutor(new Unban(this));
		getCommand("yg").setExecutor(new Reload(this));
		getServer().getPluginManager().registerEvents(new Cursing(this), this);
		getConfig().options().copyDefaults(true);
		saveConfig();
	}
}