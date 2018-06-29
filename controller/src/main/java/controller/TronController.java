package jpu2016.dogfight.controller;

import java.io.IOException;
import java.util.ArrayList;

import jpu2016.dogfight.model.IDogfightModel;
import jpu2016.dogfight.model.IMobile;
import jpu2016.dogfight.model.Missile;
import jpu2016.dogfight.model.Position;
import jpu2016.dogfight.view.IViewSystem;
import controller.IOrderPerformer;
import controller.IUserOrder;
import model.Direction;
import model.ILightCycle;
import model.ITronModel

public class TronController implements IOrderPerformer {
	private static int						TIME_SLEEP	= 30;
	private final ITronModel tronModel;
	private boolean isGameOver	= false;
	private IViewSystem viewSystem;


	public TronController(final ITronModel tronModel) {
		this.tronModel = tronModel;
	}

	@Override
	public void orderPerform(final IUserOrder userOrder) {
		if (userOrder != null) {
			final ILightCycle plane = this.tronModel.getLightCycleByPlayer(userOrder.getPlayer());
			if (plane != null) {
				Direction direction;
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
				plane.setDirection(direction);
			}
		}
	}

	private boolean isWeaponOnMobile(final IMobile mobile, final IMobile weapon) {
		if (((weapon.getPosition().getX() / weapon.getWidth()) >= (mobile.getPosition().getX() / weapon.getWidth()))
				&& ((weapon.getPosition().getX() / weapon.getWidth()) <= ((mobile.getPosition().getX() + mobile.getWidth()) / weapon.getWidth()))) {
			if (((weapon.getPosition().getY() / weapon.getHeight()) >= (mobile.getPosition().getY() / weapon.getHeight()))
					&& ((weapon.getPosition().getY() / weapon.getHeight()) <= ((mobile.getPosition().getY() + mobile.getHeight()) / weapon.getHeight()))) {
				return true;
			}
		}
		return false;
	}

	private void manageCollision(final IMobile weapon) {
		final ArrayList<IMobile> target = new ArrayList<IMobile>();
		boolean isTargetHit = false;

		for (final IMobile mobile : this.dogfightModel.getMobiles()) {
			if (this.isWeaponOnMobile(mobile, weapon)) {
				target.add(mobile);
			}
		}
		for (final IMobile mobile : target) {
			isTargetHit = isTargetHit || mobile.hit();
		}
		if (isTargetHit) {
			this.dogfightModel.removeMobile(weapon);
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

			final ArrayList<IMobile> initialMobiles = new ArrayList<IMobile>();
			for (final IMobile mobile : this.dogfightModel.getMobiles()) {
				initialMobiles.add(mobile);
			}
			for (final IMobile mobile : initialMobiles) {
				mobile.move();
				if (mobile.isWeapon()) {
					this.manageCollision(mobile);
				}
			}
			this.dogfightModel.setMobilesHavesMoved();
		}
	}

	public void setViewSystem(final IViewSystem viewSystem) {
		this.viewSystem = viewSystem;
	}
}
