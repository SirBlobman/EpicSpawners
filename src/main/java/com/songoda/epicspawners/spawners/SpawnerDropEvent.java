package com.songoda.epicspawners.spawners;

import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

/**
 * Created by songoda on 4/22/2017.
 */
public class SpawnerDropEvent extends Event implements Cancellable {
    private static final HandlerList HANDLERS = new HandlerList();

    private Location location;
    private Player player;
    private int multi;
    private EntityType type;

    private boolean canceled = false;

    public SpawnerDropEvent(Location location, Player player) {
        Spawner spawner = new Spawner(location);
        this.location = location;
        this.player = player;
        this.multi = spawner.getMulti();
        if (spawner.getSpawner() == null)
            this.type = null;
        else
            this.type = spawner.getSpawner().getSpawnedType();
    }

    public Location getLocation() {
        return location;
    }

    public Player getPlayer() {
        return player;
    }

    public int getMulti() {
        return multi;
    }

    public EntityType getType() {
        return type;
    }

    @Override
    public HandlerList getHandlers() {
        return HANDLERS;
    }
    public static HandlerList getHandlerList() {
        return HANDLERS;
    }

    @Override
    public boolean isCancelled() {
        return canceled;
    }

    @Override
    public void setCancelled(boolean canceled) {
        this.canceled = canceled;

    }
}