package com.mina.net.codec;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.CumulativeProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolDecoderOutput;

import com.netty.annotations.AnnotationType;
import com.netty.annotations.Edit;

/**
 * The login decoder class to represent decoding
 * for the login session once logged in.
 * 
 * @author Joshua Rodrigues
 * @since Sep 19, 2011 11:26:06 AM
 */
@Edit(getAnnotationType = AnnotationType.EDIT)
public class LoginMINA extends CumulativeProtocolDecoder {

	/*
	 * (non-Javadoc)
	 * @see org.apache.mina.filter.codec.CumulativeProtocolDecoder#doDecode(org.apache.mina.core.session.IoSession, org.apache.mina.core.buffer.IoBuffer, org.apache.mina.filter.codec.ProtocolDecoderOutput)
	 */
	@Override
	protected boolean doDecode(IoSession ioSession, IoBuffer ioBuffer, ProtocolDecoderOutput pdo) {
		return false;
	}
}