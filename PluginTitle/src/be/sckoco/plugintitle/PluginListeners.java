package be.sckoco.plugintitle;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;

public class PluginListeners implements Listener {
	
	@EventHandler
	public void OnClick(InventoryClickEvent event) {
		InventoryView inv = event.getView();
		Player player = (Player) event.getWhoClicked();
		ItemStack current = event.getCurrentItem();
		
		if(current == null) return;
		
		if(inv.getTitle().equalsIgnoreCase("§8Monnaies")) {
			
			event.setCancelled(true);
			
			player.getInventory().addItem(current);
			player.updateInventory();
			
		}
	}
	
}
