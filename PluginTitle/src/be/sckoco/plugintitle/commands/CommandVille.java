package be.sckoco.plugintitle.commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandVille implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender instanceof Player) {
			Player player = (Player) sender;
			
			Location ville = new Location(Bukkit.getWorld("world"), 56801.530, 73, 55031.508, -1.0f, 0.2f);
			
			player.sendMessage("§6Téléportation à la ville terminée");
			player.teleport(ville);
			
			return true;
		}
		return false;
	}

}
