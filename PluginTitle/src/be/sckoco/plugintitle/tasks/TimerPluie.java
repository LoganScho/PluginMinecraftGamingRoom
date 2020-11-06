package be.sckoco.plugintitle.tasks;

import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

import be.sckoco.plugintitle.Main;

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
			Bukkit.broadcastMessage("�6Entrez �eoui�6 si vous voulez arr�ter la pluie");
			Bukkit.broadcastMessage("�6Vous avez 30 secondes");
		}
		
		if(main.nbPlayerStopRain >= nbPlayer/2) {
			Bukkit.getWorld("world").setStorm(false);
			Bukkit.broadcastMessage("�6La pluie s'arr�te...");
			cancel();
		}
		
		if(timer == 15) {
			Bukkit.broadcastMessage("�6Il vous reste 15 secondes pour arr�ter la pluie");
		}
		
		if(timer == 0) {
			Bukkit.broadcastMessage("�6Le temps est �coul�, vous n'avez pas arr�ter la pluie");
			cancel();
		}
		timer--;
		
	}
	
}
