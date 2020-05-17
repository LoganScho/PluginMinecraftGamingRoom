package be.sckoco.plugintitle.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandRdm implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player) {
			Player p = (Player) sender;
			
				
			if(p.isOp()) {
				for(Player pl : Bukkit.getOnlinePlayers()) {
					pl.sendTitle("§4Redémarrage du serveur !", null, 10, 70, 20);
				}
			}
			return true;
		}
		else {
			for(Player pl : Bukkit.getOnlinePlayers()) {
				pl.sendTitle("§4Redémarrage du serveur !", null, 10, 70, 20);
			}
		}
		return false;
	}

}
