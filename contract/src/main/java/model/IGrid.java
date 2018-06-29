package model;

public interface IGrid {

	public int getX();
	public int getY();
	public void createGrid();
	public void setWall(EnumWall wall);
	public EnumWall getWall();
}