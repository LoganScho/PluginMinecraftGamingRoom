package be.sckoco.plugintitle;

import java.util.Iterator;

import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
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
	
	@EventHandler
	public void OnPlayerMessage(AsyncPlayerChatEvent event) {
		
		String message = event.getMessage();
		Iterator<Player> it = event.getRecipients().iterator();
		
		while(it.hasNext()) {
			Player receiver = it.next();
			if(message.contains(receiver.getName())) {
				receiver.sendMessage("§6Vous avez été mentionné !");;
				receiver.playSound(receiver.getLocation(), Sound.ENTITY_CAT_AMBIENT, 1.0f, 1.0f);
				receiver.playSound(receiver.getLocation(), Sound.BLOCK_BELL_USE, 1.0f, 1.0f);
			}
		}
		
	}
	
}
