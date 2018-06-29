package model;

import java.awt.*;
import java.util.ArrayList;
import java.util.Observable;

public class TronModel extends Observable implements ITronModel{
    private Grid grid;
    private final ArrayList<ILightCycle> lightCycles;

    public TronModel() {
        this.lightCycles = new ArrayList<>();
    }

    @Override
    public IGrid getGrid() {
        return this.grid;
    }

    @Override
    public void createGrid() {
        this.grid = new Grid();
    }

    @Override
    public void addLightCycle(final ILightCycle lightCycle) {
        this.lightCycles.add(lightCycle);
        lightCycle.setTronModel(this);
    }

    @Override
    public ArrayList<ILightCycle> getLightCycles() {
        return this.lightCycles;
    }

    @Override
    public ILightCycle getLightCycleByPlayer(final int player) {
        for (final ILightCycle lightCycle : this.lightCycles) {
            if (lightCycle.isPlayer(player)) {
                return lightCycle;
            }
        }
        return null;
    }

    @Override
    public void setLightCyclesHaveMoved() {
        this.setChanged();
        this.notifyObservers();
    }
}
