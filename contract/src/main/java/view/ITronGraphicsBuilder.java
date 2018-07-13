package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.ImageObserver;

public interface ITronGraphicsBuilder {

	void applyModelToGraphic(Graphics graphics, ImageObserver observer);

}
