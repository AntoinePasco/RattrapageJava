package model;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Observable;
import model.IGrid;
import model.WallEnum;
import model.dao.TronDAO;

public class Grid extends Observable implements IGrid {
private int x ;
private int y ;
ArrayList<ILightCycles> lightCycles;
WallEnum[][] briks;


public Grid (final int x, final int y) {
	this.x = x;
	this.y = y;
	this.lightCycles = new ArrayList<ILightCycles>();
	this.briks = new WallEnum[x][y];
	this.createGrid();
}

@Override
public void createGrid() {
	 for (int x = 0; x < this.x; x++) {
         for (int y = 0; y < this.y; y++) {
             if ((x == 0) || (x == (this.x - 1)) || (y == 0) || (y == (this.y - 1))) {
            	 
                 this.setBriksXY(WallEnum.WALL, x, y);
                 
             } else {
            	 
                 this.setBriksXY(WallEnum.GROUND, x, y);
             }
         }
     }
}

@Override
public int getX() {
	return this.x;
}

@Override
public void setX(int x) {
	this.x = x;
}

@Override
public int getY() {
	return this.y;
}

@Override
public void setY(int y) {
	this.y = y;
}

@Override
public WallEnum getBriksXY(final int x, final int y) {
    return this.briks[x][y];
}

@Override
public void setBriksXY(WallEnum briks, int x, int y) {
	this.briks[x][y] = briks;
}

@Override
public ArrayList<ILightCycles> getLightCycles() {
	return this.lightCycles;
}

@Override
public ILightCycles getMobileByPlayer(final int player) {
    for (final ILightCycles lightCycle : this.lightCycles) {
        if (lightCycle.isPlayer(player)) {
            return lightCycle;
        }
    }
    return null;
}

@Override
public void setLightCyclesHavesMoved() {
	this.setChanged();
	this.notifyObservers();
	
}

@Override
public void addLightCycles(ILightCycles lightCycles) {
	this.lightCycles.add(lightCycles);
	lightCycles.setGrid(this);
	
}

@Override
public void addWall(int player) {
	 this.setBriksXY(WallEnum.getWallByPlayer(player),
             this.getMobileByPlayer(player).getPosition().getX(),
             this.getMobileByPlayer(player).getPosition().getY());

 }

@Override
public void setResult(int player, long time) throws SQLException {
	 TronDAO.setResult(player, time);
	
}

@Override
public void update(Observable o, Object arg) {
	// TODO Auto-generated method stub
	
}


}
