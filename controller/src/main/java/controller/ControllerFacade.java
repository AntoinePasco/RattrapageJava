package controller;

import java.sql.SQLException;
import model.Imodel;
import view.IView;
import java.util.Observer;
import java.util.Observable;

/**
 * <h1>The Class ControllerFacade provides a facade of the Controller component.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public class ControllerFacade implements IController, Observer {

    /** The view. */

    /** The model. */
    /**
     * Instantiates a new controller facade.
     *
     * @param view
     *            the view
     * @param model
     *            the model
     */
	private IOrderPerformer order;
    public ControllerFacade(final IView view, final Imodel modelFacade) {
        super();
     //  view.setGrid(modelFacade.getGrid());
       // view.setOrderPerformer(this.getOrderPerformer());
        //model.addObserver(view);
    }

    private IOrderPerformer getOrderPerformer() {
		// TODO Auto-generated method stub
		return this.order;
	}

	/**
     * Start.
     *
     * @throws SQLException
     *             the SQL exception
     */
    public void start() throws SQLException {
    	
      /*  this.getView().displayMessage(this.getModel().getExampleById(1).toString());

        this.getView().displayMessage(this.getModel().getExampleByName("Example 2").toString());

        final List<Example> examples = this.getModel().getAllExamples();
        final StringBuilder message = new StringBuilder();
        for (final Example example : examples) {
            message.append(example);
            message.append('\n');
        }
        this.getView().displayMessage(message.toString());*/
    	// startView();
    	 // startModel();
        
    }

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void orderPerform(IUserOrder userOrder) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void checkCollision() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void play() throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void gameLoop() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setView(IView view) {
		// TODO Auto-generated method stub
		
	}

   /* public void startView() {
    	 Graphics graphics = null;
		this.getView().drawAllLightCycles(graphics);
    }
    
  /*  public void startModel() {
    	this.getGrid().addLightCycles(null);
        this.getModel().buildGrid();
        this.getModel().getGrid();
        this.getGrid().getLightCycles();
        this.getGrid().getMobileByPlayer(1);
        this.getGrid().setMobilesHavesMoved();
    }
    /**
     * Gets the view.
     *
     * @return the view
     */
   /* public IView getView() {
        return this.view;
    }

    public IGrid getGrid() {
    	return this.grid;
    }
    /**
     * Gets the model.
     *
     * @return the model
     */
   /* public ITronModel getModel() {
        return this.model;
    }*/
}
