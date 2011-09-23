package com.netty.demo;

/**
 * An interface to indicate that an implementation
 * will be allowed to speak in a real voice
 * dependent upon who it is - mainly an NPC.
 * @author Josh
 * @since 0.1
 */
public interface Speechable {

	/**
	 * Gets the speech used from the NPC throughout
	 * the demo.
	 * @return
	 * 			Returns the speech.
	 */
	public String getSpeech();
}