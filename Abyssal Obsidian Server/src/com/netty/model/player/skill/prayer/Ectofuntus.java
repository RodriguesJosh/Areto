package com.netty.model.player.skill.prayer;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 22, 2011 9:40:51 AM
 */
public class Ectofuntus {

	/**
	 * 
	 */
	private Bone bone;

	/**
	 * 
	 * @param bone
	 * 			The id to set.
	 */
	public Ectofuntus(Bone bone) {
		this.setBone(bone);
	}

	/**
	 * 
	 * @param bone
	 * 			The id to set.
	 */
	public void setBone(Bone bone) {
		this.bone = bone;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public Bone getBone() {
		return this.bone;
	}
}