package com.mina.net.codec;

import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolEncoder;
import org.apache.mina.filter.codec.ProtocolEncoderOutput;

import com.netty.annotations.AnnotationType;
import com.netty.annotations.Edit;

/**
 * An encoder class to represent the encoding
 * of a packet that we send to the client.
 * 
 * @author Joshua Rodrigues
 * @since Sep 19, 2011 11:25:50 AM
 */
@Edit(getAnnotationType = AnnotationType.EDIT)
public class EncoderMINA implements ProtocolEncoder {

	/*
	 * (non-Javadoc)
	 * @see org.apache.mina.filter.codec.ProtocolEncoder#encode(org.apache.mina.core.session.IoSession, java.lang.Object, org.apache.mina.filter.codec.ProtocolEncoderOutput)
	 */
	@Override
	public void encode(IoSession ioSession, Object object, ProtocolEncoderOutput peo) {
		return;
	}

	/*
	 * (non-Javadoc)
	 * @see org.apache.mina.filter.codec.ProtocolEncoder#dispose(org.apache.mina.core.session.IoSession)
	 */
	@Override
	public void dispose(IoSession ioSession) {
		return;
	}
}