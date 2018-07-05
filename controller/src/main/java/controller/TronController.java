package controller;

import java.util.ArrayList;
import view.IViewSystem;
import model.Direction;
import model.ILightCycle;
import model.ITronModel;
import model.IGrid;

public class TronController implements IOrderPerformer, ITronController {
	private static int TIME_SLEEP = 30;
	private final ITronModel tronModel;
	private boolean isGameOver	= false;
	private IViewSystem viewSystem;
	ILightCycle lightCycle;
    Direction direction;
    IGrid grid;


	public TronController(final ITronModel tronModel) {
		this.tronModel = tronModel;
	}

	@Override
	public void orderPerform(final IUserOrder userOrder) {
		if (userOrder != null) {
			final ILightCycle lightCycle = this.grid.getLightCycleByPlayer(userOrder.getPlayer());
			if (lightCycle != null) {

				switch (userOrder.getOrder()) {
					case UP:
						direction = Direction.UP;
						break;
					case RIGHT:
						direction = Direction.RIGHT;
						break;
					case DOWN:
						direction = Direction.DOWN;
						break;
					case LEFT:
						direction = Direction.LEFT;
						break;
					default:
						direction = this.grid.getLightCycleByPlayer(userOrder.getPlayer()).getDirection();
						break;
				}
				lightCycle.setDirection(direction);
			}
		}
	}

	 public boolean isWeaponOnMobile(final ILightCycle lightCycle, final ILightCycle weapon) {
		if (((weapon.getPosition().getX() / weapon.getWidth()) >= (lightCycle.getPosition().getX() / weapon.getWidth()))
				&& ((weapon.getPosition().getX() / weapon.getWidth()) <= ((lightCycle.getPosition().getX() + lightCycle.getWidth()) / weapon.getWidth()))) {
			if (((weapon.getPosition().getY() / weapon.getHeight()) >= (lightCycle.getPosition().getY() / weapon.getHeight()))
					&& ((weapon.getPosition().getY() / weapon.getHeight()) <= ((lightCycle.getPosition().getY() + lightCycle.getHeight()) / weapon.getHeight()))) {
				return true;
			}
		}
		return false;
	}

	public void manageCollision(final ILightCycle weapon) {
		final ArrayList<ILightCycle> target = new ArrayList<ILightCycle>();
		boolean isTargetHit = false;

		for (final ILightCycle mobile : this.grid.getLightCycles()) {
			if (this.isWeaponOnMobile(mobile, weapon)) {
				target.add(mobile);
			}
		}
		for (final ILightCycle lightCycle : target) {
			isTargetHit = isTargetHit || lightCycle.hit();
		}
		if (isTargetHit) {
			this.grid.removeLightCycle(weapon);
			this.isGameOver = true;
		}
	}

	public void play() {
		this.gameLoop();
		this.viewSystem.displayMessage("Game Over !");
		this.viewSystem.closeAll();
	}

	public void gameLoop() {
		while (!this.isGameOver) {
			try {
				Thread.sleep(TIME_SLEEP);
			} catch (final InterruptedException ex) {
				Thread.currentThread().interrupt();
			}

			final ArrayList<ILightCycle> initialLightCycles = new ArrayList<ILightCycle>();
			for (final ILightCycle mobile : this.grid.getLightCycles()) {
				initialLightCycles.add(mobile);
			}
			for (final ILightCycle lightCycle : initialLightCycles) {
				lightCycle.move();
				if (lightCycle.isWeapon()) {
					this.manageCollision(lightCycle);
				}
			}
			this.grid.setLightCyclesHaveMoved();
		}
	}

	public void setViewSystem(final IViewSystem viewSystem) {
		this.viewSystem = viewSystem;
	}
}
