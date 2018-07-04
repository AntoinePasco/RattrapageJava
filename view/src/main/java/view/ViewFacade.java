package view;

import java.awt.Graphics;
import java.awt.event.KeyEvent;

import javax.swing.JOptionPane;

import controller.IOrderPerformer;
import model.IGrid;
import model.ILightCycle;
import model.ITronModel;

/**
 * <h1>The Class ViewFacade provides a facade of the View component.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public class ViewFacade implements IView, IEventPerformer {
    IGrid grid;
    ITronModel tron;
    IOrderPerformer order;
    GraphicsBuilder graphicBuilder;
    TronFrame frame;
    EventPerformer event;
    Graphics graphics;
    /**
     * Instantiates a new view facade.
     */
    public ViewFacade() {
        super();
        this.frame = new TronFrame("test", tron);
        graphicBuilder = new GraphicsBuilder(grid, graphics);
        event = new EventPerformer(order);
    }

    /*
     * (non-Javadoc)
     * @see view.IView#displayMessage(java.lang.String)
     */
    @Override
    public final void displayMessage(final String message) {
        JOptionPane.showMessageDialog(null, message);
    }

    public final void drawAllLightCycles(final Graphics graphics) {
        graphicBuilder.applyModelToGraphic(graphics);
    }

    @Override
    public void eventPerform(KeyEvent keyCode) {
        event.eventPerform(keyCode);

    }
}