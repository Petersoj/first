package com.petersoj.DEVproject;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.messaging.PluginMessageListener;

public class Tellz implements PluginMessageListener {
	Plugin pl;

	public Tellz(Plugin p) {
		this.pl = p;
		Bukkit.getServer().getMessenger().registerOutgoingPluginChannel(p, "BungeeCord");
		Bukkit.getServer().getMessenger().registerIncomingPluginChannel(p, "BungeeCord", this);
	}

	@Override
	public void onPluginMessageReceived(String arg0, Player arg1, byte[] arg2) {
		
	}
}
