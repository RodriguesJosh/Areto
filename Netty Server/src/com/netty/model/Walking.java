package com.netty.model;

import java.util.Deque;
import java.util.LinkedList;

import com.netty.model.player.Energy;
import com.netty.model.player.Player;
import com.netty.util.Constants;
import com.netty.util.DirectionUtility;
import com.netty.world.Location;

public class Walking {

	private Entity entity;
	private Deque<Point> walkingPointList;
	private boolean runToggled;
	private boolean runQueue;

	public Walking(Entity entity) {
		this.setEntity(entity);
		this.setWalkingPointList(new LinkedList<Point>());
		this.setRunningToggled(false);
		this.setRunningQueue(false);
	}

	public boolean isRunning() {
		return this.isRunningToggled() || this.isRunningQueue();
	}

	public void resetWalking() {
		this.setRunningQueue(false);
		Deque<Point> walkingPointList = this.getWalkingPointList();
		walkingPointList.clear();
		walkingPointList.add(new Point(this.getEntity().getLocation(), (byte) -1));
	}

	public boolean isEmpty() {
		return this.getWalkingPointList().size() <= 0;
	}

	public void finish() {
		this.getWalkingPointList().removeFirst();
	}

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

	public void setEntity(Entity entity) {
		this.entity = entity;
	}

	public Entity getEntity() {
		return this.entity;
	}

	public void setWalkingPointList(Deque<Point> walkingPointList) {
		this.walkingPointList = walkingPointList;
	}

	public Deque<Point> getWalkingPointList() {
		return this.walkingPointList;
	}

	public void setRunningToggled(boolean runToggled) {
		this.runToggled = runToggled;
	}

	public boolean isRunningToggled() {
		return this.runToggled;
	}

	public void setRunningQueue(boolean runQueue) {
		this.runQueue = runQueue;
	}

	public boolean isRunningQueue() {
		return this.runQueue;
	}
}