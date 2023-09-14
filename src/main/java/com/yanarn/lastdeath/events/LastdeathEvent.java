package com.yanarn.lastdeath.events;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class LastdeathEvent implements Listener {
    // 死んだときにプレイヤーに死んだ座標を送信
    @EventHandler
    public void onPlayerDeathEvent(PlayerDeathEvent e) {
        Player player = e.getPlayer();
        Location loc = player.getLocation();
        player.sendMessage("あなたの死んだ場所は X:" + loc.getX() + " Y:" + loc.getY() + " Z:"  + loc.getZ() + " です。");

    }
}
