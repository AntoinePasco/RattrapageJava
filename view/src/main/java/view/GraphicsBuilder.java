package view;

import java.awt.Graphics;
import model.ILightCycle;
import model.IGrid;

public class GraphicsBuilder {
    private final IGrid grid;
    private ILightCycle lightCycle;

    public GraphicsBuilder(IGrid grid) {
        this.grid = grid;
    }

    private void clearGraphics(Graphics graphics) {
        graphics.clearRect(0, 0, this.grid.getX() * 3, this.grid.getY() * 3);
    }

    private void drawLightCycles(final Graphics graphics) {
        graphics.setColor(lightCycle.getColor());
        graphics.fillRect(lightCycle.getWidth() * TronFrame.ZOOM, lightCycle.getHeight() * TronFrame.ZOOM, TronFrame.ZOOM, TronFrame.ZOOM);

    }

    private void drawAllLightCycles(final Graphics graphics) {
        for (final ILightCycle lightCycles : this.grid.getCopyOfLightCycles()) {
            this.drawLightCycles(graphics);
        }
    }

    public void applyModelToGraphic(Graphics graphics) {
        this.clearGraphics(graphics);
        this.drawAllLightCycles(graphics);
    }
}
