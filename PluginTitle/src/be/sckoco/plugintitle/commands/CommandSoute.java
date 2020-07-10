package be.sckoco.plugintitle.commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandSoute implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender instanceof Player) {
			Player player = (Player) sender;
			
			Location tp = new Location(Bukkit.getWorld("world"), 297.695, 61, 97.483, 90.1f, 6.0f);
			
			player.teleport(tp);
			player.sendMessage("§6Téléportaion secrète terminée");
			
			return true;
		}
		return false;
	}

}