package be.sckoco.plugintitle.commands;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.Repairable;

public class CommandMonnaie implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player) {
			Player p = (Player) sender;
			
			if(p.isOp()) {
				Inventory inv = Bukkit.createInventory(null, 9, "§8Monnaies");
				
				p.openInventory(inv);
				
				//Monnaie
				ItemStack monnaie = new ItemStack(Material.SUNFLOWER, 64);
				ItemMeta monnaieM = monnaie.getItemMeta();
				monnaieM.setDisplayName("Monnaie");
				monnaieM.addEnchant(Enchantment.THORNS, 3, true);
				monnaieM.addEnchant(Enchantment.LOOT_BONUS_MOBS, 3, true);
				monnaieM.addEnchant(Enchantment.MENDING, 1, true);
				monnaie.setItemMeta(monnaieM);
				Repairable monnaieR = (Repairable) monnaie.getItemMeta();
				monnaieR.setRepairCost(7);
				monnaie.setItemMeta((ItemMeta) monnaieR);
				inv.setItem(3, monnaie);
				
				//Billet 10
				ItemStack billetDix = new ItemStack(Material.GOLD_INGOT, 64);
				ItemMeta billetDixM = billetDix.getItemMeta();
				billetDixM.setDisplayName("Billet 10");
				billetDixM.addEnchant(Enchantment.MENDING, 1, true);
				billetDixM.addEnchant(Enchantment.PIERCING, 4, true);
				billetDixM.addEnchant(Enchantment.QUICK_CHARGE, 3, true);
				billetDixM.addEnchant(Enchantment.CHANNELING, 1, true);
				billetDixM.addEnchant(Enchantment.LOYALTY, 3, true);
				billetDixM.addEnchant(Enchantment.ARROW_FIRE, 1, true);
				billetDix.setItemMeta(billetDixM);
				Repairable billetDixR = (Repairable) billetDix.getItemMeta();
				billetDixR.setRepairCost(511);
				billetDix.setItemMeta((ItemMeta) billetDixR);
				inv.setItem(2, billetDix);
				
				//Billet 100
				ItemStack billetCent = new ItemStack(Material.GOLD_BLOCK, 64);
				ItemMeta billetCentM = billetCent.getItemMeta();
				billetCentM.setDisplayName("Billet 100");
				billetCentM.addEnchant(Enchantment.SILK_TOUCH, 1, true);
				billetCentM.addEnchant(Enchantment.MENDING, 1, true);
				billetCentM.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, true);
				billetCentM.addEnchant(Enchantment.DAMAGE_ALL, 5, true);
				billetCentM.addEnchant(Enchantment.LOYALTY, 3, true);
				billetCentM.addEnchant(Enchantment.CHANNELING, 1, true);
				billetCentM.addEnchant(Enchantment.MULTISHOT, 1, true);
				billetCentM.addEnchant(Enchantment.WATER_WORKER, 1, true);
				billetCentM.addEnchant(Enchantment.THORNS, 3, true);
				billetCent.setItemMeta(billetCentM);
				Repairable billetCentR = (Repairable) billetCent.getItemMeta();
				billetCentR.setRepairCost(511);
				billetCent.setItemMeta((ItemMeta) billetCentR);
				inv.setItem(1, billetCent);
				
				//Billet 1000
				ItemStack billetMille = new ItemStack(Material.DIAMOND_BLOCK, 64);
				ItemMeta billetMilleM = billetMille.getItemMeta();
				billetMilleM.setDisplayName("Billet 1000");
				billetMilleM.addEnchant(Enchantment.RIPTIDE, 3, true);
				billetMilleM.addEnchant(Enchantment.DIG_SPEED, 5, true);
				billetMilleM.addEnchant(Enchantment.DURABILITY, 3, true);
				billetMilleM.addEnchant(Enchantment.MENDING, 1, true);
				billetMilleM.addEnchant(Enchantment.QUICK_CHARGE, 3, true);
				billetMilleM.addEnchant(Enchantment.PIERCING, 4, true);
				billetMilleM.addEnchant(Enchantment.LOOT_BONUS_MOBS, 3, true);
				billetMilleM.addEnchant(Enchantment.LURE, 3, true);
				billetMilleM.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 3, true);
				billetMille.setItemMeta(billetMilleM);
				Repairable billetMilleR = (Repairable) billetMille.getItemMeta();
				billetMilleR.setRepairCost(511);
				billetMille.setItemMeta((ItemMeta) billetMilleR);
				inv.setItem(0, billetMille);
				
				p.openInventory(inv);
				
				return true;
			}
		}
		return false;
	}

}
