package com.schiebros.hide;

import java.util.Map;

import com.schiebros.hide.interfaces.HiddenCommand;

public final class CommandUtil {

	private CommandUtil() {
	}
	
	public static void enableCommand(HiddenCommand command) {
		Main.COMMANDS.put(command.getLabel(), command);
	}
	
	public static void disableCommand(HiddenCommand command) {
		Main.COMMANDS.put(command.getLabel(), null);
	}
	
	public static Main getPlugin() {
		return Main.plugin;
	}
	
	public static Map<String, HiddenCommand> getAllCommands() {
		return Main.COMMANDS;
	}
	
}
