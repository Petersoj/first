package com.petersoj.DEVproject;

import net.md_5.bungee.api.ChatColor;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

public class Rifle implements Listener {

	public static ItemStack rifle;

	public Rifle(Plugin p) {
		rifle = new ItemStack(Material.IRON_HOE);
		Inventoryz.giveName(rifle, ChatColor.DARK_RED + "Machine Gun", null);
		Bukkit.getServer().getPluginManager().registerEvents(this, p);
	}

	Player p;
	static Snowball snowball;

	@EventHandler
	public void onInteract(PlayerInteractEvent e) {
		p = e.getPlayer();
		
		if (e.getAction() == Action.LEFT_CLICK_BLOCK|| e.getAction() == Action.LEFT_CLICK_AIR || e.getPlayer().getItemInHand() == new ItemStack(Material.AIR))
			return;

		if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK && e.getPlayer().getItemInHand() != new ItemStack(Material.AIR)) {
			if (e.getItem().getItemMeta().getDisplayName().contains("Machine Gun")) {
					snowball = p.getWorld().spawn(p.getEyeLocation(), Snowball.class);
					snowball.setVelocity(p.getLocation().getDirection().multiply(2.5));
					snowball.setShooter(p);
					p.playSound(p.getLocation(), Sound.FALL_SMALL, 10, (float) 0.5);
			}else{
				return;
			}
		}else{
			return;
		}
	}
}
