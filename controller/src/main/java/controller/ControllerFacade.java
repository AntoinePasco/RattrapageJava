package controller;

import java.awt.Graphics;
import java.sql.SQLException;
import java.util.List;

import model.Example;
import model.IGrid;
import model.ILightCycle;
import model.ITronModel;
import view.IEventPerformer;
import view.IView;

/**
 * <h1>The Class ControllerFacade provides a facade of the Controller component.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public class ControllerFacade implements IController {

    /** The view. */
    private final IView  view;

    /** The model. */
    private final ITronModel model;
    private final IGrid grid;
    /**
     * Instantiates a new controller facade.
     *
     * @param view
     *            the view
     * @param model
     *            the model
     */
    public ControllerFacade(final IView view, final ITronModel model, IGrid grid) {
        super();
        this.view = view;
        this.model = model;
        this.grid = grid;
    }

    /**
     * Start.
     *
     * @throws SQLException
     *             the SQL exception
     */
    public void start() throws SQLException {

      /*  this.getView().displayMessage(this.getModel().getExampleById(1).toString());

        this.getView().displayMessage(this.getModel().getExampleByName("Example 2").toString());

        final List<Example> examples = this.getModel().getAllExamples();
        final StringBuilder message = new StringBuilder();
        for (final Example example : examples) {
            message.append(example);
            message.append('\n');
        }
        this.getView().displayMessage(message.toString());*/
        startView();
        startModel();

    }

    public void startView() {
        Graphics graphics = null;
        this.getView().drawAllLightCycles(graphics);
    }

    public void startModel() {
        this.getGrid().addLightCycle(null);
        this.getModel().createGrid();
        this.getModel().getGrid();
        this.getGrid().getLightCycles();
        this.getGrid().getLightCycleByPlayer(1);
        this.getGrid().setLightCyclesHaveMoved();
    }
    /**
     * Gets the view.
     *
     * @return the view
     */
    public IView getView() {
        return this.view;
    }

    public IGrid getGrid() {
        return this.grid;
    }
    /**
     * Gets the model.
     *
     * @return the model
     */
    public ITronModel getModel() {
        return this.model;
    }
}
