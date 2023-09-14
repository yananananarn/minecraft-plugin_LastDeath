package com.yanarn.lastdeath;

import com.yanarn.lastdeath.events.LastdeathEvent;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public final class LastDeath extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getLogger().info("Enable LastDeath Command");
        Bukkit.getPluginManager().registerEvents(new LastdeathEvent(),this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        // コマンドを実行した際の処理
        if (command.getName().equalsIgnoreCase("lastdeath")) {
            Player player = (Player) sender;
            Location loc = player.getLastDeathLocation();

            // 引数がない場合
            // 死んだ場所を表示する
            if (args.length == 0) {
                player.sendMessage("あなたの死んだ場所は X:" + loc.getX() + " Y:" + loc.getY() + " Z:" + loc.getZ() + " です。");
                return true;
            }
            // 引数がある場合
            else {
                // 死んだ場所にテレポートする
                if (args[0].equalsIgnoreCase("tp")) {
                    player.teleport(loc);
                    player.sendMessage("最後に死んだ場所にテレポートしました");
                    return true;
                }
            }
        }
        // コマンドが該当しない場合
        return false;
    }
}
