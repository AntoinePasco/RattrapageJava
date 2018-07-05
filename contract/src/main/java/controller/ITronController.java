package controller;

import model.Direction;
import model.ILightCycle;
import model.ITronModel;
import view.IViewSystem;

import java.util.ArrayList;

public interface ITronController {
    public void orderPerform(final IUserOrder userOrder);
    boolean isWeaponOnMobile(final ILightCycle lightCycle, final ILightCycle weapon);
    void manageCollision(final ILightCycle weapon);
    public void play();
    void gameLoop();
    public void setViewSystem(final IViewSystem viewSystem);
}

