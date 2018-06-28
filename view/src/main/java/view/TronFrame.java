package view;

import javax.swing.JFrame;

import jpu2016.javapetri.model.JavaPetri;

public class TronFrame extends JFrame {
    private static final long	serialVersionUID	= -1112124206501543946L;
    public static final int		ZOOM							= 3;

    public TronFrame(final String title, final Tron tron) {

        this.setTitle(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);

        final TronPanel easyPanel = new TronPanel(new TronGraphicsBuilder(tron));
        this.setContentPane(easyPanel);
        this.setSize((tron.getWidth() * ZOOM) + this.getInsets().left + this.getInsets().right,
                (tron.getHeight() * ZOOM) + this.getInsets().top + this.getInsets().bottom);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        tron.addObserver(tronPanel);
    }
}
