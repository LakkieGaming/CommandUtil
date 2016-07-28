package com.schiebros.hide;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.plugin.java.JavaPlugin;

import com.schiebros.hide.interfaces.HiddenCommand;

public final class Main extends JavaPlugin implements Listener {

	// "COMMANDS" is in full caps just because of the convention.
	protected static final Map<String, HiddenCommand> COMMANDS = new HashMap<String, HiddenCommand>();
	
	protected static Main plugin;
	
	public void onEnable() {
		plugin = this;
		Bukkit.getPluginManager().registerEvents(this, this);
	}
	
	@EventHandler
	public void onCommandExecute(PlayerCommandPreprocessEvent e) {
		Player pl = e.getPlayer();
		String message = e.getMessage();
		String[] components;
		if (message.contains(" ")) {
			components = message.split(" ");
		} else {
			components = new String[1];
			components[0] = message;
		}
		String[] args = new String[components.length - 1];
		for (int i = 1; i < components.length; i++) {
			args[i - 1] = components[i];
		}
		e.setCancelled(true);
		String label = components[0].replaceFirst("/", "");
		if (!COMMANDS.containsKey(label)) {
			pl.sendMessage("Unknown command. Type \"/help\" for help.");
			return;
		}
		HiddenCommand cmd = COMMANDS.get(label);
		cmd.onCommandExecute(pl, args);
	}
	
}
