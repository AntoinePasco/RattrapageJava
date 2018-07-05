package main;

import java.sql.SQLException;

import controller.ITronController;
import controller.TronController;
import model.*;
import view.IViewSystem;
import model.ILightCycle;

/**
 * <h1>The Class Main.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public abstract class Main {


    /**
     * The main method.
     *
     * @param args
     *            the arguments
     */
    public static void main(final String[] args) {
        final ITronModel tronModel = new TronModel();
        final IDimension dimension;
        final IGrid grid = new Grid();
        final ILightCycle lightCycle = new LightCycle(, , );
        final ITronController tronController;
        final IViewSystem viewSystem = new viewSystem;
        final IPosition positon = new position();

        createGrid.dimension(1000, 700);
        grid.addLightCycle(new LightCycle(0, new position(10, 60), "0"));
        grid.addLightCycle(new LightCycle(1, new position(10, 590), "1"));
        TronController.setViewSystem(IViewSystem viewSystem);
        TronController.play();
    }  try {
            controller.start();
        } catch (final SQLException exception) {
            exception.printStackTrace();
        }
    }

}
