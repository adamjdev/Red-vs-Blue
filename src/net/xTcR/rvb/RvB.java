package net.xTcR.rvb;

import org.bukkit.plugin.java.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.logging.*;

import org.bukkit.plugin.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;
import org.bukkit.*;

public class RvB extends JavaPlugin
{
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
    
    
    public RvB() {
        this.logger = Logger.getLogger("Minecraft");
    }
    
    public void onDisable() {
        final PluginDescriptionFile pdfFile = this.getDescription();
        this.logger.info(String.valueOf(pdfFile.getName()) + " Has Been Disabled!");
    }
    
    public void onEnable() {
        final PluginDescriptionFile pdfFile = this.getDescription();
        this.logger.info(String.valueOf(pdfFile.getName()) + " Has Been Enabled!");
    }
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
