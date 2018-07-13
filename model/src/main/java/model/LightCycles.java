package model;

import java.awt.Color;

public class LightCycles implements ILightCycles {
private int direction;
private Color color;
private IPosition position;
private int player;
private IGrid grid;
private boolean alive;

public LightCycles(final int direction,final IPosition position, final Color color,final int player) {
this.position = position;
this.color = color;
this.player = player;
this.alive = true;
this.direction = direction;

}


@Override
public void move() {
	switch (this.direction) {
	
	case 0:
		this.moveUp();
		break;
	case 1:
		this.moveRight();
		break;
	case 2:
		this.moveDown();
		break;
	case 3: 
		this.moveLeft();
		break;
	}
}


public void moveUp() {
	this.position.setY(this.position.getY() + 1);
}

public void moveDown() {
	this.position.setY(this.position.getY() - 1);
}

public void moveRight() {
	this.position.setX(this.position.getX()+1);
}

public void moveLeft() {
	this.position.setX(this.position.getX()-1);
}

@Override
public int getDirection() {
    return this.direction;
}

@Override
public int setDirection(final int direction) {
    return this.direction = direction;

}

@Override
public Color getColor() {
	// TODO Auto-generated method stub
	return this.color;
}


@Override
public void setColor(Color color) {
	this.color = color;
	
}


@Override
public boolean isPlayer(final int player) {
	 return this.player == player;
}


@Override
public boolean isWeapon() {
	return true;
}


@Override
public IPosition getPosition() {
	return this.position;
}

@Override
public void setPosition(final IPosition position) {
    this.position = position;

}

public IGrid getGrid() {
    return this.grid;
}

@Override
public void setGrid(final IGrid grid) {
    this.grid = grid;
}


@Override
public void die() {
	this.alive = false;
	
}


@Override
public boolean isAlive() {
	 return this.alive;
}


}
