package model;

public enum WallEnum {
	WALL,
	RED_WALL,
	BLUE_WALL,
	GROUND;
	
	 public static WallEnum getWallByPlayer(final int player) {
	        if (player == 0) {
	            return WallEnum.BLUE_WALL;
	            
	        } else if (player == 1) {
	            return WallEnum.RED_WALL;
	            
	        } else {
	            return WallEnum.WALL;
	        }
	    }

	public boolean isWall() {
		 return (this == WALL) || (this == RED_WALL) || (this == BLUE_WALL);
	}
}
