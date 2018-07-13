package view;

import java.awt.Graphics;
import java.io.IOException;
import java.util.Observable;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import controller.IOrderPerformer;
import model.IGrid;

public class TronView implements IView, Runnable {
    private final TronGraphicsBuilder tronGraphicsBuilder;
    private final EventPerformer      eventPerformer;
    private final Observable          observable;
    private TronFrame                 tronFrame;
    private IGrid                     grid;
    private Graphics graphics;

    public TronView(final IOrderPerformer orderPerformer, final IGrid grid, final Observable observable) {
        this.observable = observable;
        this.tronGraphicsBuilder = new TronGraphicsBuilder(grid);
        this.eventPerformer = new EventPerformer(orderPerformer);
        this.grid = grid;
        SwingUtilities.invokeLater(this);

    }

    @Override
    public void run() {
        this.tronFrame = new TronFrame("Tron", this.eventPerformer, this.tronGraphicsBuilder, this.grid,
                this.observable);
        // TODO Auto-generated method stub

    }

    @Override
    public void displayMessage(final String message) {
        JOptionPane.showMessageDialog(null, message);
        // TODO Auto-generated method stub
    }

    @Override
    public void closeAll() {
        this.tronFrame.dispose();
    }

    public IGrid getGrid() {
        return this.grid;
    }

    public void setGrid(final IGrid grid) throws IOException {
        this.grid = grid;
    }


}