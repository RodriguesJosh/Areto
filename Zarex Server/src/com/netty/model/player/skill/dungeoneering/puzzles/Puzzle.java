package com.netty.model.player.skill.dungeoneering.puzzles;

import com.netty.model.player.skill.SkillType;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 22, 2011 10:02:13 AM
 */
public abstract class Puzzle {

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public abstract SkillType[] getRequiredSkills();
}