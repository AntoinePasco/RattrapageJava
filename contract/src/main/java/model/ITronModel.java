package model;

import java.util.ArrayList;

public interface ITronModel {

    public IGrid getGrid();
    public void createGrid();
    public void addLightCycle(final ILightCycle lightCycle);
    public ArrayList<ILightCycle> getLightCycles();
    public ILightCycle getLightCycleByPlayer(final int player);
    public void setLightCyclesHaveMoved();
}
