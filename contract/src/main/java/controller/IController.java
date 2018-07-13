package controller;

import java.sql.SQLException;

import view.IView;

/**
 * <h1>The Interface IController.</h1>
 * 
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public interface IController {
		public void orderPerform(final IUserOrder userOrder);

	    public void checkCollision();

	    public void play() throws SQLException;

	    public void gameLoop();

	    public void setView(final IView view);
}
