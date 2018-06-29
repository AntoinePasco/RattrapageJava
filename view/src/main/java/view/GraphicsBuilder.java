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

    /*private void drawAllJavaCell(Graphics graphics) {
        Iterator var3 = this.javaPetri.getCopyOfJavaCells().iterator();

        while(var3.hasNext()) {
            JavaCell javaCell = (JavaCell)var3.next();
            this.drawJavaCell(graphics, javaCell);
        }
    }*/

    private void drawLightCycle(Graphics graphics, IGrid grid) {
        graphics.setColor(ILightCycle.getColor());
        graphics.fillRect(lightCycle.getWidth() * 3, lightCycle.getHeight() * 3, 3, 3);
    }

    public void applyModelToGraphic(Graphics graphics) {
        this.clearGraphics(graphics);
        //this.drawAllJavaCell(graphics);
    }
}
