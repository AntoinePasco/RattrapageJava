package model;

import java.util.ArrayList;
import java.util.Observable;

public class TronModel extends Observable implements ITronModel {
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
}
