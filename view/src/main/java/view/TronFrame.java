package view;

import java.awt.Component;
import javax.swing.JFrame;
import model.IGrid;

public class TronFrame extends JFrame {
        private static final long serialVersionUID = -1112124206501543946L;
        public static final int ZOOM = 3;

        public TronFrame(String title,IGrid grid) {
            this.setTitle(title);
            this.setDefaultCloseOperation(3);
            this.setResizable(false);
            this.setVisible(true);
            TronPanel tronPanel = new TronPanel(new GraphicsBuilder(grid));
            this.setContentPane(tronPanel);
            this.setSize(grid.getX() * 3 + this.getInsets().left + this.getInsets().right, grid.getY() * 3 + this.getInsets().top + this.getInsets().bottom);
            this.setLocationRelativeTo((Component)null);
            this.setVisible(true);
            grid.addObserver(tronPanel);
        }
    }
}
