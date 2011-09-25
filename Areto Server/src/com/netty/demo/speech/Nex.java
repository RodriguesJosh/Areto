package com.netty.demo.speech;

import com.netty.annotations.AnnotationType;
import com.netty.annotations.Edit;
import com.netty.demo.Speechable;

/**
 * An NPC, Nex, that will be able to
 * talk within the chat box as well as
 * your speakers.
 * 
 * @author Joshua Rodrigues
 * @since Sep 19, 2011 5:40:43 PM
 */
@Edit(getAnnotationType = AnnotationType.EDIT)
public class Nex implements Speechable {

	/*
	 * (non-Javadoc)
	 * @see com.netty.demo.Speechable#getSpeech()
	 */
	@Override
	public String getSpeech() {
		return "";
	}
}