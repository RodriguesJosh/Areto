package com.netty.model;

import java.util.Deque;
import java.util.LinkedList;

import com.netty.model.player.Energy;
import com.netty.model.player.Player;
import com.netty.util.Constants;
import com.netty.util.DirectionUtility;
import com.netty.world.Location;

/**
 * 
 * 
 * @author Joshua Rodrigues
 * @since Sep 20, 2011 7:43:48 PM
 */
public class Walking {

	/**
	 * 
	 */
	private Entity entity;

	/**
	 * 
	 */
	private Deque<Point> walkingPointList;

	/**
	 * 
	 */
	private boolean runToggled;

	/**
	 * 
	 */
	private boolean runQueue;

	/**
	 * 
	 * 
	 * @param entity
	 * 			The entity to set.
	 */
	public Walking(Entity entity) {
		this.setEntity(entity);
		this.setWalkingPointList(new LinkedList<Point>());
		this.setRunningToggled(false);
		this.setRunningQueue(false);
	}

	/**
	 * 
	 * 
	 * @return false
	 */
	public boolean isRunning() {
		return this.isRunningToggled() || this.isRunningQueue();
	}

	/**
	 * 
	 */
	public void resetWalking() {
		this.setRunningQueue(false);
		Deque<Point> walkingPointList = this.getWalkingPointList();
		walkingPointList.clear();
		walkingPointList.add(new Point(this.getEntity().getLocation(), (byte) -1));
	}

	/**
	 * 
	 * 
	 * @return false
	 */
	public boolean isEmpty() {
		return this.getWalkingPointList().size() <= 0;
	}

	/**
	 * 
	 */
	public void finish() {
		this.getWalkingPointList().removeFirst();
	}

	/**
	 * 
	 * 
	 * @param location
	 * 			The location to set.
	 */
	public void addStep(Location location) {
		if (this.isEmpty()) {
			this.resetWalking();
		}
		Point lastPoint = this.getWalkingPointList().peekLast();
		if (lastPoint == null) {
			return;
		}
		short x = location.getX();
		short y = location.getY();
		byte differenceX = (byte) (x - lastPoint.getLocation().getX());
		byte differenceY = (byte) (y - lastPoint.getLocation().getY());
		short max = (short) Math.max(Math.abs(differenceX), Math.abs(differenceY));
		for (short i = 0; i < max; i++) {
			if (differenceX < 0) {
				differenceX++;
			} else if (differenceX > 0) {
				differenceX--;
			}
			if (differenceY < 0) {
				differenceY++;
			} else if (differenceY > 0) {
				differenceY--;
			}
			byte stepX = (byte) (x - differenceX);
			byte stepY = (byte) (y - differenceY);
			this.addStepInternal(new Location(stepX, stepY, location.getZ()));
		}
	}

	/**
	 * 
	 * 
	 * @param stepLocation
	 * 			The location to set.
	 */
	private void addStepInternal(Location stepLocation) {
		Deque<Point> walkingPointList = this.getWalkingPointList();
		if (walkingPointList.size() >= 50) {
			return;
		}
		short x = stepLocation.getX();
		short y = stepLocation.getY();
		Point lastPoint = walkingPointList.peekLast();
		byte differenceX = (byte) (x - lastPoint.getLocation().getX());
		byte differenceY = (byte) (y - lastPoint.getLocation().getY());
		Location location = new Location(differenceX, differenceY, lastPoint.getLocation().getZ());
		byte direction = DirectionUtility.getDirection(differenceX, differenceY);
		if (direction > -1) {
			walkingPointList.add(new Point(location, direction));
		}
	}

	/**
	 * 
	 */
	public void processNextMovement() {
		Point walkingPoint = null;
		Point runningPoint = null;
		Entity entity = this.getEntity();
		Player player = (Player) entity;
		if (player.isTeleporting()) {
			this.resetWalking();
			entity.setLocation(player.getTeleport().getTeleportingLocation());
			player.resetTeleport();
		} else {
			walkingPoint = this.getNextPoint();
			if (entity instanceof Player) {
				if (player.getEnergy().getEnergyAmount() < 100) {
					player.setEnergy(new Energy(player.getEnergy().getEnergyAmount() + 0.25));
				}
			}
			if (this.isRunning()) {
				boolean runningAllowed = false;
				if (entity instanceof Player) {
					runningAllowed = (player.getEnergy().getEnergyAmount() > 0);
				}
				if (runningAllowed) {
					runningPoint = this.getNextPoint();
				}
				if (runningPoint != null) {
					if (entity instanceof Player) {
						player.setEnergy(new Energy(player.getEnergy().getEnergyAmount() - 0.88));
					}
				}
			}
			byte walkDirection = walkingPoint == null ? -1 : walkingPoint.getDirection();
			byte runDirection = runningPoint == null ? -1 : runningPoint.getDirection();
			entity.setWalkingDirection(walkDirection);
			entity.setRunningDirection(runDirection);
		}
		byte differenceX = (byte) (entity.getLocation().getX() - (entity.getLastLocation().getRegionX() * 8));
		byte differenceY = (byte) (entity.getLocation().getY() - (entity.getLastLocation().getRegionY() * 8));
		boolean changed = false;
		if (differenceX < 16) {
			changed = true;
		} else if (differenceX >= 88) {
			changed = true;
		}
		if (differenceY < 16) {
			changed = true;
		} else if (differenceY >= 88) {
			changed = true;
		}
		if (changed) {
			entity.setMapChanging(true);
		}
	}

	/**
	 * 
	 * 
	 * @return point
	 */
	private Point getNextPoint() {
		Point point = this.getWalkingPointList().poll();
		if (point == null) {
			return null;
		}
		byte direction = point.getDirection();
		if (direction == -1) {
			return null;
		}
		Entity entity = this.getEntity();
		if (entity == null) {
			return null;
		}
		short x = Constants.DIRECTION_DELTA_X[direction];
		short y = Constants.DIRECTION_DELTA_Y[direction];
		Location location = new Location(x, y, (byte) 0);
		entity.setLocation(entity.getLocation().addLocation(location));
		return point;
	}

	/**
	 * 
	 * 
	 * @param entity
	 * 			The entity to set.
	 */
	public void setEntity(Entity entity) {
		this.entity = entity;
	}

	/**
	 * 
	 * @return entity
	 */
	public Entity getEntity() {
		return this.entity;
	}

	/**
	 * 
	 * @param walkingPointList
	 * 			The walking point list to set.
	 */
	public void setWalkingPointList(Deque<Point> walkingPointList) {
		this.walkingPointList = walkingPointList;
	}

	/**
	 * 
	 * @return walkingPointList
	 */
	public Deque<Point> getWalkingPointList() {
		return this.walkingPointList;
	}

	/**
	 * 
	 * @param runToggled
	 * 			The run toggled to set.
	 */
	public void setRunningToggled(boolean runToggled) {
		this.runToggled = runToggled;
	}

	/**
	 * 
	 * @return runToggled
	 */
	public boolean isRunningToggled() {
		return this.runToggled;
	}

	/**
	 * 
	 * @param runQueue
	 * 			The running queue to set.
	 */
	public void setRunningQueue(boolean runQueue) {
		this.runQueue = runQueue;
	}

	/**
	 * 
	 * @return runQueue
	 */
	public boolean isRunningQueue() {
		return this.runQueue;
	}
}