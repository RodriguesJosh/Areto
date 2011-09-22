package com.mina.net.codec;

import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFactory;
import org.apache.mina.filter.codec.ProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolEncoder;

public class CodecFactoryMINA implements ProtocolCodecFactory {

	private EncoderMINA encoderMINA = new EncoderMINA();
	private DecoderMINA decoderMINA = new DecoderMINA();
	private LoginMINA loginMINA = new LoginMINA();
	private boolean isLoginFactory = false;
	private static CodecFactoryMINA loginFactory = new CodecFactoryMINA(true);
	private static CodecFactoryMINA gameFactory = new CodecFactoryMINA(false);

	public CodecFactoryMINA(boolean loginFactory) {
		this.setLoginFactory(loginFactory);
	}

	@Override
	public ProtocolDecoder getDecoder(IoSession ioSession) {
		return (ProtocolDecoder) (this.isLoginFactory() ? this.getLogin() : this.getDecoder());
	}

	@Override
	public ProtocolEncoder getEncoder(IoSession ioSession) {
		return this.getEncoder();
	}

	public void setEncoder(EncoderMINA encoderMINA) {
		this.encoderMINA = encoderMINA;
	}

	public EncoderMINA getEncoder() {
		return this.encoderMINA;
	}

	public void setDecoder(DecoderMINA decoderMINA) {
		this.decoderMINA = decoderMINA;
	}

	public DecoderMINA getDecoder() {
		return this.decoderMINA;
	}

	public void setLogin(LoginMINA loginMINA) {
		this.loginMINA = loginMINA;
	}

	public LoginMINA getLogin() {
		return this.loginMINA;
	}

	public void setLoginFactory(boolean isLoginFactory) {
		this.isLoginFactory = isLoginFactory;
	}

	public boolean isLoginFactory() {
		return this.isLoginFactory;
	}

	public static void setLoginFactory(CodecFactoryMINA loginFactory) {
		CodecFactoryMINA.loginFactory = loginFactory;
	}

	public static CodecFactoryMINA getLoginFactory() {
		return CodecFactoryMINA.loginFactory;
	}

	public static void setGameFactory(CodecFactoryMINA gameFactory) {
		CodecFactoryMINA.gameFactory = gameFactory;
	}

	public static CodecFactoryMINA getGameFactory() {
		return CodecFactoryMINA.gameFactory;
	}
}