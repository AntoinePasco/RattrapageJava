package main;

import java.awt.Color;
import java.sql.SQLException;

import controller.TronController;
import model.Grid;
import model.LightCycles;
import model.Position;
import view.TronView;

/**
 * <h1>The Class Main.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public abstract class Main {
    /**
     * The main method.
     *
     * @param args
     *            the arguments
     */
 	private final static  int width = 200;
	private final static int height = 400;
    public static void main(final String[] args) throws SQLException {
   
           /* final ITronModel tronModel = new TronModel();
            final IDimension dimension;
            final IGrid grid = new Grid();
            final ILightCycle lightCycle = new LightCycle(, , );
            final ITronController tronController;
            final IViewSystem viewSystem = new ViewSystem();
            final IPosition positon = new position();

            grid.createGrid(); //dimension(400, 600);
            grid.addLightCycle(new LightCycle(0, 10, color.blue));
            grid.addLightCycle(new LightCycle(1, new position(10, 590), "red"));
            TronController.setViewSystem(IViewSystem viewSystem);
            TronController.play();
        }  try {
                controller.start();
            } catch (final SQLException exception) {
                exception.printStackTrace();
            }
        }*/
    	
  //   final ControllerFacade controller = new ControllerFacade(new ViewFacade(), new ModelFacade());

      /*  try {
            controller.start();
        } catch (final SQLException exception) {
            exception.printStackTrace();
        }*/
    		
    	  final Grid grid = new Grid(Main.width, Main.height);
          grid.addLightCycles(new LightCycles(2, new Position(50, 50), Color.cyan, 0));
          grid.addLightCycles(new LightCycles(2, new Position(100, 200), Color.PINK, 1));
          final TronController controller = new TronController(grid);
          controller.setView(new TronView(controller, grid, grid));
          try {
              controller.play();
          } catch (final SQLException exception) {
              exception.printStackTrace();
          }
      }
    }

