package me.quesia.peepopractice.core.category.properties;

import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("UnusedDeclaration")
public class WorldProperties extends BaseProperties {
    private RegistryKey<World> worldRegistryKey;
    private boolean spawnChunksDisabled = false;
    private final Map<Biome, @Nullable Integer> antiBiomeRangeMap = new HashMap<>();
    private final Map<Biome, @Nullable Integer> proBiomeRangeMap = new HashMap<>();

    public RegistryKey<World> getWorldRegistryKey() {
        return this.worldRegistryKey;
    }

    public boolean hasWorldRegistryKey() {
        return this.worldRegistryKey != null;
    }

    public WorldProperties setWorldRegistryKey(RegistryKey<World> worldRegistryKey) {
        this.worldRegistryKey = worldRegistryKey;
        return this;
    }

    public boolean isSpawnChunksDisabled() {
        return this.spawnChunksDisabled;
    }

    public WorldProperties setSpawnChunksDisabled(boolean spawnChunksDisabled) {
        this.spawnChunksDisabled = spawnChunksDisabled;
        return this;
    }

    public Map<Biome, Integer> getAntiBiomeRangeMap() {
        return this.antiBiomeRangeMap;
    }

    public WorldProperties addAntiBiomeRange(Biome biome, @Nullable Integer range) {
        this.antiBiomeRangeMap.put(biome, range);
        return this;
    }

    public Map<Biome, Integer> getProBiomeRangeMap() {
        return this.proBiomeRangeMap;
    }

    public WorldProperties addProBiomeRange(Biome biome, @Nullable Integer range) {
        this.proBiomeRangeMap.put(biome, range);
        return this;
    }
}
