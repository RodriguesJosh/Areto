package com.netty.net;

import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.ChannelPipelineFactory;
import org.jboss.netty.channel.Channels;

import com.netty.net.codec.Decoder;
import com.netty.net.codec.Encoder;
import com.netty.net.codec.Handler;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 21, 2011 1:33:43 PM
 */
public class Pipeline implements ChannelPipelineFactory {

	/* (non-Javadoc)
	 * @see org.jboss.netty.channel.ChannelPipelineFactory#getPipeline()
	 */
	@Override
	public ChannelPipeline getPipeline() {
		ChannelPipeline channelPipeline = Channels.pipeline();
		channelPipeline.addLast("encoder", new Encoder());
		channelPipeline.addLast("decoder", new Decoder());
		channelPipeline.addLast("handler", new Handler());
		return channelPipeline;
	}
}
