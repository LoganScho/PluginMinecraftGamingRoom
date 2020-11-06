package be.sckoco.plugintitle.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import be.sckoco.plugintitle.Main;
import be.sckoco.plugintitle.State;
import be.sckoco.plugintitle.tasks.TimerPluie;

public class CommandStopRain implements CommandExecutor {
	
	private Main main;
	
	public CommandStopRain(Main main) {
		this.main = main;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(sender instanceof Player) {
			Player p = (Player) sender;
			
			if(!Bukkit.getWorld("world").hasStorm()) {
				p.sendMessage("§cIl ne pleut pas actuellement");
			}
			else {
				Bukkit.broadcastMessage("§6" + p.getName() + " propose un arrêt de la pluie");
				
				TimerPluie tp = new TimerPluie(main);
				tp.runTaskTimer(main, 0, 20);
				
			}
			
			return true;
		}
		
		return false;
	}

}
