package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.ImageObserver;

import model.IGrid;
import model.ILightCycles;



public class TronGraphicsBuilder implements ITronGraphicsBuilder {
	private final IGrid grid;

	

	public TronGraphicsBuilder(final IGrid grid) {
		this.grid = grid;
	}
	

	public void createWall(final Graphics graphics) {
		 graphics.setColor(Color.WHITE);
	     graphics.drawRect(0, 0,( this.grid.getX() - 1),(this.grid.getY()- 1));
	}
	
	private void drawAllLightCycles(final Graphics graphics) {
		 for (final ILightCycles lightCycle : this.grid.getLightCycles()) {
	            this.drawLightCycle(graphics, lightCycle);
	        }
		}

	private void drawLightCycle(final Graphics graphics, final ILightCycles lightCycles) {
		graphics.setColor(lightCycles.getColor());
        graphics.fillRect(lightCycles.getPosition().getX() * TronFrame.ZOOM,
                lightCycles.getPosition().getY() * TronFrame.ZOOM, TronFrame.ZOOM, TronFrame.ZOOM);
	}

	@Override
	public void applyModelToGraphic(final Graphics graphics, final ImageObserver observer) {
		this.drawAllLightCycles(graphics);
		//this.createWall(graphics);
	}

	
}

