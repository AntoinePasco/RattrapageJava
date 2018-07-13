package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Observable;

import javax.swing.JFrame;
import model.IGrid;

public class TronFrame extends JFrame implements KeyListener{
	private static final long	serialVersionUID	= -1112124206501543946L;
	public static final int		ZOOM= 3;
	public Graphics graphics;
	IGrid grid;
	private final IEventPerformer eventPerformer;

	
	public TronFrame(final String title, final EventPerformer eventPerformer,
            final TronGraphicsBuilder tronGraphicsBuilder, final IGrid grid, final Observable observable) {
        this.eventPerformer = eventPerformer;

        this.setTitle(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.addKeyListener(this);
        this.setVisible(true);

        final TronPanel easyPanel = new TronPanel(new TronGraphicsBuilder(grid));
        this.setContentPane(easyPanel);
        this.setBackground(Color.BLACK);
        this.setSize((grid.getX() * TronFrame.ZOOM) + this.getInsets().left + this.getInsets().right,
                (grid.getY() * TronFrame.ZOOM) + this.getInsets().top + this.getInsets().bottom);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        observable.addObserver(easyPanel);
    }

    @Override
    public void keyTyped(final KeyEvent keyEvent) {
 

    }

    @Override
    public void keyPressed(final KeyEvent keyEvent) {
        this.eventPerformer.eventPerform(keyEvent);
  

    }

    @Override
    public void keyReleased(final KeyEvent keyEvent) {


    }
}
