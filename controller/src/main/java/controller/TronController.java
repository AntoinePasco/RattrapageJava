package controller;

import java.util.ArrayList;
import view.IViewSystem;
import model.Direction;
import model.ILightCycle;
import model.ITronModel;

public class TronController implements IOrderPerformer {
	private static int TIME_SLEEP = 30;
	private final ITronModel tronModel;
	private boolean isGameOver	= false;
	private IViewSystem viewSystem;
	ILightCycle lightCycle;
    Direction direction;


	public TronController(final ITronModel tronModel) {
		this.tronModel = tronModel;
	}

	@Override
	public void orderPerform(final IUserOrder userOrder) {
		if (userOrder != null) {
			final ILightCycle lightCycle = this.tronModel.getLightCycleByPlayer(userOrder.getPlayer());
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
						direction = this.tronModel.getLightCycleByPlayer(userOrder.getPlayer()).getDirection();
						break;
				}
				lightCycle.setDirection(direction);
			}
		}
	}

	private boolean isWeaponOnMobile(final ILightCycle lightCycle, final ILightCycle weapon) {
		if (((weapon.getPosition().getX() / weapon.getWidth()) >= (lightCycle.getPosition().getX() / weapon.getWidth()))
				&& ((weapon.getPosition().getX() / weapon.getWidth()) <= ((lightCycle.getPosition().getX() + lightCycle.getWidth()) / weapon.getWidth()))) {
			if (((weapon.getPosition().getY() / weapon.getHeight()) >= (lightCycle.getPosition().getY() / weapon.getHeight()))
					&& ((weapon.getPosition().getY() / weapon.getHeight()) <= ((lightCycle.getPosition().getY() + lightCycle.getHeight()) / weapon.getHeight()))) {
				return true;
			}
		}
		return false;
	}

	private void manageCollision(final ILightCycle weapon) {
		final ArrayList<ILightCycle> target = new ArrayList<ILightCycle>();
		boolean isTargetHit = false;

		for (final ILightCycle mobile : this.tronModel.getLightCycles()) {
			if (this.isWeaponOnMobile(mobile, weapon)) {
				target.add(mobile);
			}
		}
		for (final ILightCycle lightCycle : target) {
			isTargetHit = isTargetHit || lightCycle.hit();
		}
		if (isTargetHit) {
			this.tronModel.removeLightCycle(weapon);
			this.isGameOver = true;
		}
	}

	public void play() {
		this.gameLoop();
		this.viewSystem.displayMessage("Game Over !");
		this.viewSystem.closeAll();
	}

	private void gameLoop() {
		while (!this.isGameOver) {
			try {
				Thread.sleep(TIME_SLEEP);
			} catch (final InterruptedException ex) {
				Thread.currentThread().interrupt();
			}

			final ArrayList<ILightCycle> initialLightCycles = new ArrayList<ILightCycle>();
			for (final ILightCycle mobile : this.tronModel.getLightCycles()) {
				initialLightCycles.add(mobile);
			}
			for (final ILightCycle lightCycle : initialLightCycles) {
				lightCycle.move();
				if (lightCycle.isWeapon()) {
					this.manageCollision(lightCycle);
				}
			}
			this.tronModel.setLightCyclesHaveMoved();
		}
	}

	public void setViewSystem(final IViewSystem viewSystem) {
		this.viewSystem = viewSystem;
	}
}
