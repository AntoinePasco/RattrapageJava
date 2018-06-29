package view;

import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JPanel;

public class TronPanel extends JPanel implements Observer {
    private static final long serialVersionUID = 3987064896591403626L;
    private final GraphicsBuilder graphicsBuilder;

    public TronPanel(GraphicsBuilder graphicsBuilder) {
        this.graphicsBuilder = graphicsBuilder;
    }

    public void update(Observable arg0, Object arg1) {
        this.repaint();
    }

    protected void paintComponent(Graphics graphics) {
        this.graphicsBuilder.applyModelToGraphic(graphics);
    }
}
