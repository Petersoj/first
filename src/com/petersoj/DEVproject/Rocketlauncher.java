package com.petersoj.DEVproject;

import net.md_5.bungee.api.ChatColor;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.entity.WitherSkull;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

public class Rocketlauncher implements Listener{
	
	public static ItemStack rocketItem;
	
	public Rocketlauncher(Plugin p){
		rocketItem = new ItemStack(Material.DIAMOND_SPADE);
		Inventoryz.giveName(rocketItem, ChatColor.GOLD + "Rocket Launcher", null);
		Bukkit.getServer().getPluginManager().registerEvents(this, p);
	}
	
	Player p;
	@EventHandler
	public void onInteract(PlayerInteractEvent e) {
		p = e.getPlayer();
		
		if (e.getAction() == Action.LEFT_CLICK_BLOCK|| e.getAction() == Action.LEFT_CLICK_AIR || e.getPlayer().getItemInHand() == new ItemStack(Material.AIR))
			return;

		if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK && e.getPlayer().getItemInHand() == new ItemStack(Material.AIR)) {
			if (e.getItem().getItemMeta().getDisplayName().contains("Rocket Launcher")) {
                p.launchProjectile(WitherSkull.class).setVelocity(p.getLocation().getDirection());
                launchPlayerBack(p);
				p.playSound(p.getLocation(), Sound.EXPLODE, 10, 2);
			}else{
				return;
			}
		}else{
			return;
		}
	}
	
	public void launchPlayerBack(Player p){
		p.setVelocity(p.getLocation().getDirection().multiply(-1));
	}

}
