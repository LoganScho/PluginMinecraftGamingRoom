package be.sckoco.plugintitle.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandRdv implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player) sender;
			
			if(p.isOp()) {
				for(Player pl : Bukkit.getOnlinePlayers()) {
					pl.sendTitle("§6Rendez-vous à l'église", null, 10, 70, 20);
				}
				return true;
			}
		}
		return false;
	}

}
