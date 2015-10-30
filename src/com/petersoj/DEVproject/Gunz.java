package com.petersoj.DEVproject;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Gunz extends JavaPlugin{
	
	Inventoryz invv;
	
	public void onEnable(){
		invv = new Inventoryz(this);
		Rifle r = new Rifle(this);
		EntityDamage dm = new EntityDamage(this);
		Rocketlauncher l = new Rocketlauncher(this);
	}
	
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		
		if(cmd.getName().equalsIgnoreCase("gunGUI")){
				p.openInventory(invv.gameInv);
			return false;
		}
		return true;
	}

}
