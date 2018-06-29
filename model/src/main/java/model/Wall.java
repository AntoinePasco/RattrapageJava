package model;


public class Wall {
    EnumWall wall;
    public void createWall() {
        switch (wall){
            case SPACE:
                createSpace();
            case RedWall:
                createRedWall();
            case BlueWall:
                createBlueWall();
        }
    }

    private void createSpace() {
        System.out.println(".");
    }
    private void createRedWall() {
        System.out.println("R");
    }
    private void createBlueWall() {
        System.out.println("B");
    }
}
