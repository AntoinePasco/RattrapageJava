package model;

import java.awt.*;

public class LightCycle implements ILightCycle {
    private int Width;
    private int Height;
    Direction direction;
    private Color color;

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

    public void setHeight(int hight) {
        this.Height = hight;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
