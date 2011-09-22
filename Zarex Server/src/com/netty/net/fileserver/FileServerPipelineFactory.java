package com.netty.net.fileserver;

import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.ChannelPipelineFactory;
import org.jboss.netty.channel.Channels;
import org.jboss.netty.handler.codec.frame.DelimiterBasedFrameDecoder;
import org.jboss.netty.handler.codec.frame.Delimiters;
import org.jboss.netty.handler.codec.string.StringDecoder;
import org.jboss.netty.handler.codec.string.StringEncoder;

public class FileServerPipelineFactory implements ChannelPipelineFactory {

	private UpdateType updateType;

	@Override
	public ChannelPipeline getPipeline() throws Exception {
		ChannelPipeline channelPipeline = Channels.pipeline();
		channelPipeline.addLast("framedecoder", new DelimiterBasedFrameDecoder(8192, Delimiters.lineDelimiter()));
		channelPipeline.addLast("decoder", new StringDecoder());
		channelPipeline.addLast("encoder", new StringEncoder());
		channelPipeline.addLast("handler", new FileServerChannelHandler(this.getUpdateType()));
		return channelPipeline;
	}

	public void setUpdateType(UpdateType updateType) {
		this.updateType = updateType;
	}

	public UpdateType getUpdateType() {
		return this.updateType;
	}
}