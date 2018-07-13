package model;

import java.awt.Color;
import java.sql.SQLException;
import java.util.List;
import java.util.Observable;

/**
 * <h1>The Class ModelFacade provides a facade of the Model component.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public final class ModelFacade extends Observable implements Imodel {
 //TronModel model;
 
    /**
     * Instantiates a new model facade.
     */
    public ModelFacade() {
      
       /*grid = new Grid();
       model = new TronModel();
       grid.createGrid();
       grid.addLightCycles(new LightCycles(1, 10, color.blue));
       grid.addLightCycles(new LightCycles(10,1, color.red));*/
    }
    
    

    /*
     * (non-Javadoc)
     * @see model.IModel#getExampleById(int)
     */
 /*   @Override
    public Example getExampleById(final int id) throws SQLException {
        return ExampleDAO.getExampleById(id);
    }

    /*
     * (non-Javadoc)
     * @see model.IModel#getExampleByName(java.lang.String)
     */
  /*  @Override
    public Example getExampleByName(final String name) throws SQLException {
        return ExampleDAO.getExampleByName(name);
    }

    /*
     * (non-Javadoc)
     * @see model.IModel#getAllExamples()
     */
   /* @Override
    public List<Example> getAllExamples() throws SQLException {
        return ExampleDAO.getAllExamples();
    }*/



	public Grid getGrid() {
		return null;
		// TODO Auto-generated method stub
		
	}



	@Override
	public Example getExampleById(int id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public Example getExampleByName(String name) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public List<Example> getAllExamples() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}



	/*public ArrayList<ILightCycles> getLightCycles() {
		// TODO Auto-generated method stub
		return grid.getLightCycles();
	}



	public ILightCycles getMobileByPlayer(int player) {
		// TODO Auto-generated method stub
		return grid.getMobileByPlayer(player);
	}



	@Override
	public void buildGrid() {
		model.buildGrid();
		// TODO Auto-generated method stub
		
	}



	public void addLightCycles(ILightCycles lightCycles) {
		grid.addLightCycles(lightCycles);
		// TODO Auto-generated method stub
		
	}



	public void setMobilesHavesMoved() {
		grid.setMobilesHavesMoved();// TODO Auto-generated method stub
		
	}



	public ArrayList<ILightCycles> getCopyOfLightCycles() {
		return grid.getCopyOfLightCycles();
	}*/

}
