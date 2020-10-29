package be.sckoco.plugintitle.commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandTemple implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(sender instanceof Player) {
			
			Player player = (Player) sender;
			Location temple = new Location(Bukkit.getWorld("world"), -87.650, 73, 220.433, 95.9f, 3.0f);
					
			player.sendMessage("§6Téléportation au temple réussie");
			player.teleport(temple);
			
			return true;
			
		}
		
		return false;
	}

}
