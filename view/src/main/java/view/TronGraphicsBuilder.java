package view;

import java.awt.Graphics;

import model.ITron;
import model.ILightCycle;

public class TronGraphicsBuilder {
    private final ITron tron;

    public TronGraphicsBuilder(final ITron tron) {
        this.tron = tron;
    }

    private void clearGraphics(final Graphics graphics) {
        graphics.clearRect(0, 0, this.tron.getWidth() * TronFrame.ZOOM, this.tron.getHeight() * TronFrame.ZOOM);
    }

    private void drawLightCycle(final Graphics graphics) {
        for (final LightCycle lightCycle : this.tron.getCopyOfLightCycle()) {
            this.drawJavaCell(graphics, lightCycle);
        }
    }

    private void drawJavaCell(final Graphics graphics, final JavaCell javaCell) {
        graphics.setColor(javaCell.getColor());
        graphics.fillRect(javaCell.getPosition().getX() * EasyFrame.ZOOM, javaCell.getPosition().getY() * EasyFrame.ZOOM, EasyFrame.ZOOM, EasyFrame.ZOOM);

    }

    public void applyModelToGraphic(final Graphics graphics) {
        this.clearGraphics(graphics);
        this.drawAllJavaCell(graphics);
    }
}
