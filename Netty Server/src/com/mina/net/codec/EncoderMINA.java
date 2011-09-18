package com.mina.net.codec;

import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolEncoder;
import org.apache.mina.filter.codec.ProtocolEncoderOutput;

public class EncoderMINA implements ProtocolEncoder {

	@Override
	public void encode(IoSession ioSession, Object object, ProtocolEncoderOutput peo) {

	}

	@Override
	public void dispose(IoSession ioSession) {

	}
}