package model;

import java.util.ArrayList;

public interface IGrid {

	public int getX();
	public int getY();
	public void createGrid();
	public void setWall(EnumWall wall);
	public EnumWall getWall();
	public IDimension getDimension();
    public ArrayList<ILightCycle> getCopyOfLightCycles();
    public void addLightCycle(final ILightCycle lightCycle);
    public ArrayList<ILightCycle> getLightCycles();
    public ILightCycle getLightCycleByPlayer(final int player);
    public void setLightCyclesHaveMoved();
    public void removeLightCycle(final ILightCycle lightCycle);
}