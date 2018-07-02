package model;

import java.awt.*;

public interface ILightCycle {
    public int getWidth();
    public int getHeight();
    public Color getColor();
    void setTronModel(ITronModel tronModel);
    boolean isPlayer(int player);
    public IPosition getPosition();
    public ITronModel getTronModel();
    Direction getDirection();
    void setDirection(Direction direction);
    public boolean hit();
    public void move();
    public boolean isWeapon();
}
