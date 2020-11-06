package be.sckoco.plugintitle.tasks;

import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

import be.sckoco.plugintitle.Main;
import be.sckoco.plugintitle.State;

public class TimerPluie extends BukkitRunnable{
	
	private Main main;
	private int timer = 30;
	private int nbPlayer = Bukkit.getOnlinePlayers().size();
	
	public TimerPluie(Main main) {
		this.main = main;
	}
	
	@Override
	public void run() {
		
		if(timer == 30) {
			main.setState(State.RAINSTOP);
			Bukkit.broadcastMessage("§6Entrez §eoui§6 si vous voulez arrêter la pluie");
			Bukkit.broadcastMessage("§6Vous avez 30 secondes");
		}
		
		if(main.nbPlayerStopRain >= nbPlayer/2) {
			Bukkit.getWorld("world").setStorm(false);
			Bukkit.broadcastMessage("§6La pluie s'arrête...");
			main.setState(State.NORMAL);
			cancel();
		}
		
		if(timer == 15) {
			Bukkit.broadcastMessage("§6Il vous reste 15 secondes pour arrêter la pluie");
		}
		
		if(timer == 0) {
			Bukkit.broadcastMessage("§6Le temps est écoulé, vous n'avez pas arrêter la pluie");
			main.setState(State.NORMAL);
			cancel();
		}
		timer--;
		
	}
	
}
