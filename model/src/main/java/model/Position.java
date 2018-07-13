package model;

public class Position implements IPosition{
	    private int x;
	    private int y;

	    public Position(final int x, final int y) {
	        this.x = x;
	        this.y = y;
	        // TODO Auto-generated constructor stub
	    }

	    public Position(final Position position) {
	        this(position.getX(), position.getY());
	    }

	    @Override
	    public int getX() {
	        return this.x;
	    }

	    @Override
	    public void setX(final int x) {
	        this.x = x;
	    }

	    @Override
	    public int getY() {
	        return this.y;
	    }

	    @Override
	    public void setY(final int y) {
	        this.y = y;
	    }

	}
