package com.grizzly.net.codec;

import com.netty.annotations.AnnotationType;
import com.netty.annotations.Edit;

/**
 * The decoder to decode packets sent
 * from the client.
 * 
 * @author Josh Rodrigues
 * @since September 18, 2011
 */
@Edit(getAnnotationType = AnnotationType.EDIT)
public class DecoderGrizzly extends AbstractDecoderGrizzly {

	/*
	 * (non-Javadoc)
	 * @see com.grizzly.net.codec.AbstractDecoderGrizzly#decode()
	 */
	@Override
	public Object decode() {
		return null;
	}
}