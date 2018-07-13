package model;

import java.awt.Color;

public interface ILightCycles {
	public void move();
	public int getDirection();
	public void setColor(Color color);
	public Color getColor();
	public boolean isPlayer(int player);
	public boolean isWeapon();
	public IPosition getPosition();
	public void setGrid(IGrid grid);
	public void die();
	public boolean isAlive();
	int setDirection(int direction);
	void setPosition(IPosition position);
}
