package com.netty.model.player.skill.slayer;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 22, 2011 12:39:10 AM
 */
public class Slayer {

	/**
	 * 
	 */
	private Assignment assignment;

	/**
	 * 
	 * @param assignment
	 * 			The id to set.
	 */
	public Slayer(Assignment assignment) {
		this.setAssignment(assignment);
		this.checkSlayer();
	}

	/**
	 * 
	 */
	public void checkSlayer() {
		if (this.getAssignment().getCreatureAmount() <= 0) {
			this.setAssignment(null);
			return;
		}
		if (this.getAssignment().getCreature().getNPC().isDead()) {
			this.getAssignment().setCreatureAmount((short) (this.getAssignment().getCreatureAmount() - 1));
		}
	}

	/**
	 * 
	 * @param assignment
	 * 			The id to set.
	 */
	public void setAssignment(Assignment assignment) {
		this.assignment = assignment;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public Assignment getAssignment() {
		return this.assignment;
	}
}