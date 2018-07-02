package model;

import java.awt.*;
import java.util.ArrayList;
import model.IGrid;

public class LightCycle extends ArrayList<ILightCycle> implements ILightCycle {
    private int Width;
    private int Height;
    Direction direction;
    private Color color;
    ITronModel tronModel;
    IPosition position;
    Dimension dimension;
    IGrid grid;

    public LightCycle(int Width, int Height, Color color){
        this.setWidth(Width);
        this.setHeight(Height);
        this.setColor(color);
    }

    public void move(){
        switch (direction){
            case UP: moveUP();
            case DOWN: moveDown();
            case LEFT: moveLeft();
            case RIGHT: moveRight();
        }
    }

    private void moveUP() {
        this.setHeight(getHeight()+1);
    }

    private void moveDown() {
        this.setHeight(getHeight()-1);
    }

    private void moveLeft() {
        this.setWidth(getWidth()-1);
    }

    private void moveRight() {
        this.setWidth(getWidth()+1);
    }


    @Override
    public int getWidth() {
        return this.Width;
    }

    public void setWidth(int width) {
        this.Width = width;
    }
    @Override
    public int getHeight() {
        return this.Height;
    }

    public void setHeight(int height) {
        this.Height = height;
    }

    public Color getColor() {
        return color;
    }

    @Override
    public void setTronModel(ITronModel tronModel) {
        this.tronModel = tronModel;
        this.getPosition().setMaxX(this.getTronModel().getGrid().getDimension().getWidth());
        this.getPosition().setMaxY(this.getTronModel().getGrid().getDimension().getHeight());
    }

    @Override
    public boolean isPlayer(int player) {
        return false;
    }

    @Override
    public IPosition getPosition() {
        return this.position;
    }

    @Override
    public ITronModel getTronModel() {
        return this.tronModel;
    }

    @Override
    public Direction getDirection() {
        return this.direction;
    }

    @Override
    public void setDirection(Direction direction) {
    this.direction = direction;
    }

    public void setColor(Color color) {
        this.color = color;
    }
    @Override
    public boolean hit() {
        grid.removeLightCycle(this);
        return true;
    }
    public boolean isWeapon() {
        return false;
    }

}
