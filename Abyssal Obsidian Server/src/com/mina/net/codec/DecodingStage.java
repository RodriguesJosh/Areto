package com.mina.net.codec;

import com.netty.annotations.AnnotationType;
import com.netty.annotations.Finished;

/**
 * An enum to represent a stage of decoding;
 * whether we are at the login decoder or we
 * are at the game decoder to decode packets.
 * 
 * @author Joshua Rodrigues
 * @since Sep 19, 2011 12:25:17 PM
 */
@Finished(getAnnotationType = AnnotationType.FINISHED)
public enum DecodingStage {

	/**
	 * Represents the game decoding stage.
	 */
	GAME_DECODER,

	/**
	 * Represents the login decoding stage.
	 */
	LOGIN_DECODER;
}