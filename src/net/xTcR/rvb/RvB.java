// net.xtcr is the default package for all xTcR minigames
package net.xTcR.rvb;

// these are the classed we need imported for RvB to work
import org.bukkit.plugin.java.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.logging.*;

import org.bukkit.plugin.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;
import org.bukkit.*;

// this is where the plugin will extend JavaPlugin
public class RvB extends JavaPlugin
{
	/* this initialized the Strings, ArrayLists, LinkedLists,
    int's, booleans, and HashMaps for RvB */
    public final Logger logger;
    public static RvB plugin;
    private final String PREFIX = ChatColor.RED + "RvB";
    public static LinkedList<Entity> red;
    public static LinkedList<Entity> blue;
    public static ArrayList<Entity> dead;
    public static ArrayList<Integer> respawn_left;
    public static HashMap<Player, Integer> scores;
    public static HashMap<Player, Integer> deaths;
    public int redScore;
    public int blueScore;
    public static int respawn_time;
    public static int timeLimit;
    public static int time;
    public static boolean unlimitedTime;
    public static boolean unlimitedScore;
    public static boolean isTeamDeathmatch;
    public static boolean isDeathmatch;
    public static final FFHandler ff_handler = new FFHandler();
    public static final DPRHandler dpr_handler = new DPRHandler();
    public static final DPMHandler dpm_handler = new DPMHandler();
    public static final DMHandler dm_handler = new DMHandler();
    
    // this will initialize the logger
    public RvB() {
        this.logger = Logger.getLogger("Minecraft");
    }
    
    // this is what will happen when the server is stopped
    public void onDisable() {
        final PluginDescriptionFile pdfFile = this.getDescription();
        this.logger.info(String.valueOf(pdfFile.getName()) + " Has Been Disabled!");
    }
    
    // This is what will happen when the server is started
    public void onEnable() {
        final PluginDescriptionFile pdfFile = this.getDescription();
        this.logger.info(String.valueOf(pdfFile.getName()) + " Has Been Enabled!");
        
        red = new LinkedList<Entity>();
        blue = new LinkedList<Entity>();
        
        dead = new ArrayList<Entity>();
        respawn_left = new ArrayList<Integer>();
        
        scores = new HashMap<Player, Integer>();
        deaths = new HashMap<Player, Integer>();
        
        isDeathmatch = false;
        
        System.out.println("[Red vs Blue] Loading config...");
        
        // loadConfig() will produce an error till later
        loadConfig();
        
        System.out.println("Red vs Blue] Config loaded!");
        
		respawn_time = getConfig().getInt("Respawn.time");

		System.out.println("[WarFighter] Setting timelimit...");

		timeLimit = getConfig().getInt("General.timelimit") / 60;

		time = getConfig().getInt("General.timelimit");

		System.out.println("Loading Time Limit...");

		unlimitedTime = getConfig().getBoolean("General.unlimtedtime");

		System.out.println("Loading Time Preferences...");

		unlimitedScore = getConfig().getBoolean("General.unlimtedscore");

		System.out.println("Loading Score Preferences...");

		System.out.println(timeLimit + "minutes");

		System.out.println("[Red vs Blue] Registering events...");
		
		// Commands will be loaded here
    }
    // This command wont matter in the future
    public final String Game_Version = "1.0";
    
	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        if (sender instanceof Player) {
            final Player player = (Player)sender;
            if (cmd.getName().equalsIgnoreCase("War")) {
                player.sendMessage(ChatColor.RED + "Minigame: Block Ops");
                player.sendMessage("");
                player.sendMessage(ChatColor.AQUA + "Author: [TekkitCommando]");
                player.sendMessage("");
                player.sendMessage(ChatColor.AQUA + "Series: War");
                player.sendMessage("");
                player.sendMessage(ChatColor.AQUA + "Version: " + Game_Version);
                player.sendMessage("");
                player.sendMessage(ChatColor.AQUA + "Website: www.xTcRMinecraft.net");
            }
        }
        return true;
    }
}
