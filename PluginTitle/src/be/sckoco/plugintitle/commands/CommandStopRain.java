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
			
			if(main.isState(State.RAINSTOP)) {
				p.sendMessage("§cUn arrêt de la pluie a déjà été proposé");
				p.sendMessage("§cEntre §eoui§c pour accepter la propostion déjà en cours");
				return true;
			}
			
			if(!Bukkit.getWorld("world").hasStorm()) {
				p.sendMessage("§cIl ne pleut pas actuellement");
			}
			else {
				Bukkit.broadcastMessage("§e" + p.getName() + "§6 propose un arrêt de la pluie");
				main.getPlayersStopRain().add(p);
				
				TimerPluie tp = new TimerPluie(main);
				tp.runTaskTimer(main, 0, 20);
				
			}
			
			return true;
		}
		
		return false;
	}

}
