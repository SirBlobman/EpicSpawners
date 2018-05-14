package com.songoda.epicspawners.api.events;

import com.songoda.epicspawners.api.EpicSpawnersAPI;
import com.songoda.epicspawners.api.spawner.Spawner;
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
    private int stackSize;
    private EntityType type;

    private boolean canceled = false;

    public SpawnerDropEvent(Location location, Player player) {
        Spawner spawner = EpicSpawnersAPI.getSpawnerManager().getSpawnerFromWorld(location);
        this.location = location;
        this.player = player;
        this.stackSize = spawner.getSpawnerDataCount();
        if (spawner.getCreatureSpawner() == null)
            this.type = null;
        else
            this.type = spawner.getCreatureSpawner().getSpawnedType();
    }

    public Location getLocation() {
        return location;
    }

    public Player getPlayer() {
        return player;
    }

    public int getStackSize() {
        return stackSize;
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

    @Deprecated
    public int getMultiSize() {
        return stackSize;
    }
}