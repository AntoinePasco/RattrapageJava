package model;

import model.EnumWall;

public class Grid implements IGrid {
    private int x = 600;
    private int y = 400;
    private EnumWall wall;


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


}
