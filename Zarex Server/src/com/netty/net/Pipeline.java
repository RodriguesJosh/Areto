package com.netty.net;

import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.ChannelPipelineFactory;
import org.jboss.netty.channel.Channels;

import com.netty.net.codec.Decoder;
import com.netty.net.codec.Encoder;
import com.netty.net.codec.Handler;

public class Pipeline implements ChannelPipelineFactory {

	@Override
	public ChannelPipeline getPipeline() {
		ChannelPipeline channelPipeline = Channels.pipeline();
		channelPipeline.addLast("encoder", new Encoder());
		channelPipeline.addLast("decoder", new Decoder());
		channelPipeline.addLast("handler", new Handler());
		return channelPipeline;
	}
}
