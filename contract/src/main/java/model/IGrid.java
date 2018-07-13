package model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Observer;

public interface IGrid extends Observer {
	 public int getX();

	    public int getY();

	    public void setX(int width);

	    public void setY(int height);

	    public WallEnum getBriksXY(int x, int y);

	    public void setBriksXY(final WallEnum motionLess, final int x, final int y);

	    public ArrayList<ILightCycles> getLightCycles();

	    ILightCycles getMobileByPlayer(int player);

	    public void setLightCyclesHavesMoved();

	    public void addWall(final int player);

	    public void addLightCycles(final ILightCycles lightCycle);

	    public void setResult(final int player, final long time) throws SQLException;

		void createGrid();
}
