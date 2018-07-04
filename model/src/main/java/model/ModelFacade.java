package model;

import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

import model.dao.ExampleDAO;

/**
 * <h1>The Class ModelFacade provides a facade of the Model component.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public final class ModelFacade implements ITronModel {
    TronModel model;
    Grid grid;

    /**
     * Instantiates a new model facade.
     */
    public ModelFacade() {
        super();
        grid = new Grid();
        model = new TronModel();
    }


    public IGrid getGrid() {
        // TODO Auto-generated method stub
        return model.getGrid();
    }


    public ArrayList<ILightCycle> getLightCycle() {
        // TODO Auto-generated method stub
        return grid.getLightCycles();
    }


    public ILightCycle getLightCycleByPlayer(int player) {
        // TODO Auto-generated method stub
        return grid.getLightCycleByPlayer(1);
    }


    @Override
    public void createGrid() {
        model.createGrid();
        // TODO Auto-generated method stub

    }


    public void addLightCycle(ILightCycle lightCycle) {
        grid.addLightCycle(lightCycle);
        // TODO Auto-generated method stub

    }


    public void setLightCyclesHaveMoved() {
        grid.setLightCyclesHaveMoved();
        // TODO Auto-generated method stub

    }


    public ArrayList<ILightCycle> getCopyOfLightCycles() {
        return grid.getCopyOfLightCycles();
    }
}