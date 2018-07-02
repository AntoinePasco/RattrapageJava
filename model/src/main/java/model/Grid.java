package model;

import java.util.ArrayList;
import java.util.Observable;

public class Grid extends Observable implements IGrid {
    private int x = 600;
    private int y = 400;
    private EnumWall wall;
    private Dimension dimension;
    LightCycle lightCycles;


    @Override
    public int getX() {
        return 0;
    }

    @Override
    public int getY() {
        return 0;
    }

    public EnumWall getWall() {
        return this.wall;
    }

    public void setWall(EnumWall wall) {
        this.wall = wall;
    }

    public Grid(){
        this.createGrid();
    }

    @Override
    public void createGrid() {
        for (int i = 0; i <= this.getX(); i++) {
            for (int j = 0; j <= this.getY(); j++) {
                this.setWall(wall.SPACE);
            }
        }
    }

    public IDimension getDimension(){
        return this.dimension;
    }

    @Override
    public ArrayList<ILightCycle> getCopyOfLightCycles() {
        final ArrayList<ILightCycle> copyOflightcycles = new ArrayList<ILightCycle>();

        for (final ILightCycle lightcycle : this.getLightCycles()) {
            copyOflightcycles.add(lightcycle);
        }
        return copyOflightcycles;
    }

    @Override
    public void addLightCycle(final ILightCycle lightCycles) {
        this.lightCycles.add(lightCycles);
        lightCycles.setTronModel(this);
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
    @Override
    public void removeLightCycle(final ILightCycle lightCycle) {
        this.lightCycles.remove(lightCycle);
    }
}
