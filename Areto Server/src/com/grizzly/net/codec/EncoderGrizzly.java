package com.grizzly.net.codec;

import org.glassfish.grizzly.Transformer;
import org.glassfish.grizzly.filterchain.AbstractCodecFilter;

import com.netty.annotations.AnnotationType;
import com.netty.annotations.Edit;

/**
 * Encodes the packet for the player
 * and then sends it to the client.
 * 
 * @author Joshua Rodrigues
 * @since Sep 18, 2011 11:57:31 PM
 */
@Edit(getAnnotationType = AnnotationType.EDIT)
public class EncoderGrizzly extends AbstractCodecFilter<EncoderGrizzly, EncoderGrizzly> {

	/**
	 * Constructs a new EncoderGrizzly
	 * to represent encoding among the
	 * Grizzly Server.
	 * 
	 * @param decoder
	 * 			The decoder for the encoder.
	 * @param encoder
	 * 			The encoder for the encoder.
	 */
	public EncoderGrizzly(Transformer<EncoderGrizzly, EncoderGrizzly> decoder, Transformer<EncoderGrizzly, EncoderGrizzly> encoder) {
		super(decoder, encoder);
	}
}