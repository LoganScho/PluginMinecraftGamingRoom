package be.sckoco.plugintitle.commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandVillage implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(sender instanceof Player) {
			Player player = (Player) sender;
			Location village = new Location(Bukkit.getWorld("world"), 224.500, 63, 36.500, -178.3f, 3.4f);
			
			player.sendMessage("§6Téléportation au village terminé");
			player.teleport(village);
			
			return true;
		}
		
		return false;
	}

}
