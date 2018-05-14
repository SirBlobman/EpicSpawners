package com.songoda.epicspawners.api;

import com.songoda.epicspawners.api.spawner.SpawnerData;
import com.songoda.epicspawners.api.spawner.SpawnerManager;
import org.bukkit.inventory.ItemStack;

public interface EpicSpawners {

    SpawnerManager getSpawnerManager();

    /**
     * Create an item representation of the provided
     * SpawnerData.
     *
     * @param data the SpawnerData for which to create
     *             an item
     * @param amount the amount of items to create
     *
     * @return new spawner item
     *
     * @see SpawnerData#toItemStack(int)
     */
    ItemStack newSpawnerItem(SpawnerData data, int amount);

    /**
     * Create an item representation of the provided
     * SpawnerData.
     *
     * @param data the SpawnerData for which to create
     *             an item
     * @param amount the amount of items to create
     * @param stackSize the amount of stacked spawners
     *
     * @return new spawner item
     *
     * @see SpawnerData#toItemStack(int, int)
     */
    ItemStack newSpawnerItem(SpawnerData data, int amount, int stackSize);

    /**
     * Get the {@link SpawnerData} applicable to this
     * ItemStack.
     *
     * @param item the item from which to retrieve
     *             SpawnerData
     *
     * @return the SpawnerData. null if item is null
     * or has no meta
     */
    SpawnerData getSpawnerDataFromItem(ItemStack item);

    /**
     * Get the amount of spawners stacked in an ItemStack.
     *
     * @param item the ItemStack to check
     *
     * @return the stack size. 1 if invalid or null.
     */
    int getStackSizeFromItem(ItemStack item);

}