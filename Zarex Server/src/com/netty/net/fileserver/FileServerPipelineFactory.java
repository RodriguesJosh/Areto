package com.netty.net.fileserver;

import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.ChannelPipelineFactory;
import org.jboss.netty.channel.Channels;
import org.jboss.netty.handler.codec.frame.DelimiterBasedFrameDecoder;
import org.jboss.netty.handler.codec.frame.Delimiters;
import org.jboss.netty.handler.codec.string.StringDecoder;
import org.jboss.netty.handler.codec.string.StringEncoder;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 21, 2011 1:21:19 PM
 */
public class FileServerPipelineFactory implements ChannelPipelineFactory {

	/**
	 * 
	 */
	private UpdateType updateType;

	/* (non-Javadoc)
	 * @see org.jboss.netty.channel.ChannelPipelineFactory#getPipeline()
	 */
	@Override
	public ChannelPipeline getPipeline() {
		ChannelPipeline channelPipeline = Channels.pipeline();
		channelPipeline.addLast("framedecoder", new DelimiterBasedFrameDecoder(8192, Delimiters.lineDelimiter()));
		channelPipeline.addLast("decoder", new StringDecoder());
		channelPipeline.addLast("encoder", new StringEncoder());
		channelPipeline.addLast("handler", new FileServerChannelHandler(this.getUpdateType()));
		return channelPipeline;
	}

	/**
	 * 
	 * @param updateType
	 * 			The id to set.
	 */
	public void setUpdateType(UpdateType updateType) {
		this.updateType = updateType;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public UpdateType getUpdateType() {
		return this.updateType;
	}
}