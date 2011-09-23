package com.mina.net.codec;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.CumulativeProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolDecoderOutput;

import com.netty.annotations.AnnotationType;
import com.netty.annotations.Edit;

/**
 * A decoder class to represent the decoding
 * of a packet that we received from the client.
 * 
 * @author Joshua Rodrigues
 * @since Sep 19, 2011 11:25:39 AM
 */
@Edit(getAnnotationType = AnnotationType.EDIT)
public class DecoderMINA extends CumulativeProtocolDecoder {

	/*
	 * (non-Javadoc)
	 * @see org.apache.mina.filter.codec.CumulativeProtocolDecoder#doDecode(org.apache.mina.core.session.IoSession, org.apache.mina.core.buffer.IoBuffer, org.apache.mina.filter.codec.ProtocolDecoderOutput)
	 */
	@Override
	protected boolean doDecode(IoSession ioSession, IoBuffer ioBuffer, ProtocolDecoderOutput arg2) {
		return false;
	}
}