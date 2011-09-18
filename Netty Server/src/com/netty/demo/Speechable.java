package com.netty.demo;

import com.netty.model.npc.NPC;

/**
 * An <code>interface</code> to indicate
 * that an implementation will be
 * allowed to speak in a real voice
 * dependent upon who it is - mainly
 * an {@link NPC}.
 * @author Josh
 * @since 0.1
 */
public interface Speechable {

	/**
	 * Gets the speech used from the
	 * <code>NPC</code> throughout the
	 * {@link Demo}.
	 */
	public String getSpeech();
}