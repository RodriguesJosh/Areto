package com.netty.model.player.skill.slayer;

public class Slayer {

	private Assignment assignment;

	public Slayer(Assignment assignment) {
		this.setAssignment(assignment);
		this.checkSlayer();
	}

	public void checkSlayer() {
		if (this.getAssignment().getCreatureAmount() <= 0) {
			this.setAssignment(null);
			return;
		}
		if (this.getAssignment().getCreature().getNPC().isDead()) {
			this.getAssignment().setCreatureAmount((short) (this.getAssignment().getCreatureAmount() - 1));
		}
	}

	public void setAssignment(Assignment assignment) {
		this.assignment = assignment;
	}

	public Assignment getAssignment() {
		return this.assignment;
	}
}