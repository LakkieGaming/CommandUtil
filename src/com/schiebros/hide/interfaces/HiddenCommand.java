package com.schiebros.hide.interfaces;

import org.bukkit.entity.Player;

public interface HiddenCommand {

	public abstract String getLabel();

	public abstract void onCommandExecute(Player pl, String[] args);
	
	
}
