package com.mina.net.codec;

import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFactory;
import org.apache.mina.filter.codec.ProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolEncoder;

import com.netty.annotations.AnnotationType;
import com.netty.annotations.Finished;

/**
 * A factory to represent numerous codecs available
 * to choose from; a decoder, an encoder and a login
 * decoder for packet/player handling.
 * 
 * @author Joshua Rodrigues
 * @since Sep 19, 2011 11:26:38 AM
 */
@Finished(getAnnotationType = AnnotationType.FINISHED)
public class CodecFactoryMINA implements ProtocolCodecFactory {

	/**
	 * An encoder to encode packets sent.
	 */
	private EncoderMINA encoderMINA = new EncoderMINA();

	/**
	 * A decoder to decode packets received.
	 */
	private DecoderMINA decoderMINA = new DecoderMINA();

	/**
	 * A login decoder to decode the login
	 * protocol sent from the client.
	 */
	private LoginMINA loginMINA = new LoginMINA();

	/**
	 * Whether or not we are at the login
	 * decoder stage.
	 */
	private DecodingStage decodingStage = DecodingStage.LOGIN_DECODER;

	/**
	 * The login factory to construct the login
	 * decoding.
	 */
	private static CodecFactoryMINA loginFactory = new CodecFactoryMINA(DecodingStage.LOGIN_DECODER);

	/**
	 * The game factory to construct the game
	 * decoding.
	 */
	private static CodecFactoryMINA gameFactory = new CodecFactoryMINA(DecodingStage.GAME_DECODER);

	/**
	 * Constructs a new codec factory for the
	 * decoding stage.
	 * 
	 * @param decodingStage
	 * 			The decoding stage to set.
	 */
	public CodecFactoryMINA(DecodingStage decodingStage) {
		this.setDecodingStage(decodingStage);
	}

	/*
	 * (non-Javadoc)
	 * @see org.apache.mina.filter.codec.ProtocolCodecFactory#getDecoder(org.apache.mina.core.session.IoSession)
	 */
	@Override
	public ProtocolDecoder getDecoder(IoSession ioSession) {
		return (this.getDecodingStage() == DecodingStage.LOGIN_DECODER ? this.getLogin() : this.getDecoder());
	}

	/*
	 * (non-Javadoc)
	 * @see org.apache.mina.filter.codec.ProtocolCodecFactory#getEncoder(org.apache.mina.core.session.IoSession)
	 */
	@Override
	public ProtocolEncoder getEncoder(IoSession ioSession) {
		return this.getEncoder();
	}

	/**
	 * Sets the encoding of the packets that will
	 * be sent to the client.
	 * 
	 * @param encoderMINA
	 * 			The encoder to set.
	 */
	public void setEncoder(EncoderMINA encoderMINA) {
		this.encoderMINA = encoderMINA;
	}

	/**
	 * Gets the encoding of the packets that we
	 * have sent.
	 * 
	 * @return encoderMINA
	 * 			Returns the MINA encoder.
	 */
	public EncoderMINA getEncoder() {
		return this.encoderMINA;
	}

	/**
	 * Sets the decoding of the packets that were
	 * received from the client.
	 * 
	 * @param decoderMINA
	 * 			The MINA decoder to set.
	 */
	public void setDecoder(DecoderMINA decoderMINA) {
		this.decoderMINA = decoderMINA;
	}

	/**
	 * Gets the decoding of the packets that we
	 * 
	 * 
	 * @return decoderMINA
	 * 			Returns the MINA decoder.
	 */
	public DecoderMINA getDecoder() {
		return this.decoderMINA;
	}

	/**
	 * Sets the login decoder to a new login
	 * decoding session for the client.
	 * 
	 * @param loginMINA
	 * 			The MINA login decoder.
	 */
	public void setLogin(LoginMINA loginMINA) {
		this.loginMINA = loginMINA;
	}

	/**
	 * Gets the login decoder to decode the login
	 * protocol.
	 * 
	 * @return loginMINA
	 * 			Returns the MINA login decoder.
	 */
	public LoginMINA getLogin() {
		return this.loginMINA;
	}

	/**
	 * Sets the decoding stage to a specific stage;
	 * a game decoder or a login decoder.
	 * 
	 * @param decodingStage
	 * 			What stage we are at for decoding.
	 */
	public void setDecodingStage(DecodingStage decodingStage) {
		this.decodingStage = decodingStage;
	}

	/**
	 * Gets the decoding stage for whether we are
	 * at the login or game decoder.
	 * 
	 * @return decodingStage
	 * 			Returns the stage we are at for
	 * 			decoding.
	 */
	public DecodingStage getDecodingStage() {
		return this.decodingStage;
	}

	/**
	 * Sets the login factory for the logging in
	 * session.
	 * 
	 * @param loginFactory
	 * 			The login codec factory.
	 */
	public static void setLoginFactory(CodecFactoryMINA loginFactory) {
		CodecFactoryMINA.loginFactory = loginFactory;
	}

	/**
	 * Gets the login factory for the logging in
	 * session.
	 * 
	 * @return loginFactory
	 * 			The login codec factory.
	 */
	public static CodecFactoryMINA getLoginFactory() {
		return CodecFactoryMINA.loginFactory;
	}

	/**
	 * Sets the game factory for the game play.
	 * 
	 * @param gameFactory
	 * 			The game codec factory.
	 */
	public static void setGameFactory(CodecFactoryMINA gameFactory) {
		CodecFactoryMINA.gameFactory = gameFactory;
	}

	/**
	 * Gets the game factory for game decoding
	 * purposes.
	 * 
	 * @return gameFactory
	 * 			The game codec factory.
	 */
	public static CodecFactoryMINA getGameFactory() {
		return CodecFactoryMINA.gameFactory;
	}
}