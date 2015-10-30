package com.petersoj.DEVproject;

import java.util.ArrayList;

import net.md_5.bungee.api.ChatColor;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

public class Inventoryz implements Listener {
	
	ItemStack rifle, getRid, rocket;
	ArrayList<String> loreForRifle, loreForRocket;
	Inventory gameInv;
	
	public Inventoryz(Plugin p){
		rifle = new ItemStack(Material.IRON_HOE);
		getRid = new ItemStack(Material.BARRIER);
		rocket = new ItemStack(Material.DIAMOND_SPADE);
		
		loreForRifle = new ArrayList<String>();
		loreForRifle.add(0, ChatColor.GRAY + "This is a Machine Gun that");
		loreForRifle.add(1, ChatColor.GRAY + "shoots snowballs that damage!");
		giveName(rifle, ChatColor.DARK_RED + "Machine Gun", loreForRifle);
		
		loreForRocket = new ArrayList<String>();
		loreForRocket.add(0, ChatColor.GRAY + "This is a Rocket Launcher!!!");
		loreForRocket.add(1, ChatColor.GRAY + "You know what this does ;)");
		giveName(rocket, ChatColor.GOLD + "Rocket Launcher", loreForRocket);
		
		giveName(getRid, ChatColor.RED + "Clear all gun Items!", null);
		
		gameInv = Bukkit.getServer().createInventory(null, 9, ChatColor.DARK_RED + "Gun GUI");
		
		gameInv.setItem(0, rifle);
		gameInv.setItem(8, getRid);
		gameInv.setItem(1, rocket);

        Bukkit.getServer().getPluginManager().registerEvents(this, p);

	}

	
	 public static ItemStack giveName(ItemStack stack , String name , ArrayList<String> list){
	      ItemMeta meta = stack.getItemMeta();
	      meta.setDisplayName(name);
	      meta.setLore(list);
	      stack.setItemMeta(meta);
	      return stack;
	 }
	 
	
	@EventHandler
	public void onInventoryClick(InventoryClickEvent e){
		Inventory invName = e.getClickedInventory();
		ItemStack clicked = e.getCurrentItem();
		Player player = (Player) e.getWhoClicked();
		
		if(invName.getTitle().contains("Gun GUI")){
			if(clicked.getType().equals(Material.IRON_HOE)){
				e.setCancelled(true);
				player.getInventory().addItem(Rifle.rifle);
			}
			if(clicked.getType().equals(Material.BARRIER)){
				e.setCancelled(true);
				Inventory i = player.getInventory();
				if(i.contains(Rifle.rifle)){
					i.remove(Rifle.rifle);
				}
				if(i.contains(Rocketlauncher.rocketItem)){
					i.remove(Rocketlauncher.rocketItem);
				}
			}
			if(clicked.getType().equals(Material.DIAMOND_SPADE)){
				e.setCancelled(true);
				player.getInventory().addItem(Rocketlauncher.rocketItem);
			}
		}
	}
	
	
}









