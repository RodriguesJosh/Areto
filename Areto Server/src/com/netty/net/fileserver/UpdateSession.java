package com.netty.net.fileserver;

import java.nio.ByteBuffer;

import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBuffers;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelFutureListener;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 21, 2011 1:18:45 PM
 */
public class UpdateSession {

	/**
	 * 
	 */
	private Channel channel;

	/**
	 * 
	 */
	private UpdateType updateType;

	/**
	 * 
	 */
	private Request request;

	/**
	 * 
	 * @param updateType
	 * 			The id to set.
	 * @param channel
	 * 			The id to set.
	 */
	public UpdateSession(UpdateType updateType, Channel channel) {
		this.updateType = updateType;
		this.channel = channel;
	}

	/**
	 * 
	 * @param line
	 * 			The id to set.
	 */
	public void readLine(String line) {
		if (this.request == null) {
			switch (this.updateType) {
				case JAGGRAB:
					this.readJAGGRABPath(line);
					break;
				case HTTP:
					this.readHTTPPath(line);
					break;
			}
		} else {
			if (this.getUpdateType() == UpdateType.HTTP) {
				if (line.length() == 0) {
					this.serve();
				}
			}
		}
	}

	/**
	 * 
	 */
	private void serve() {
		/** if (this.request == null) {
			this.channel.close();
			return;
		}
		logger.fine("Serving " + type + " request : " + this.request.getPath());
		Response resp = RequestHandler.handle(this.request);
		if (resp.getRespCode() == ResponseCode.NOT_FOUND) {
			this.error404(resp);
			return;
		}
		StringBuilder header = new StringBuilder();
		if (type == Type.HTTP) {
			header.append("HTTP/1.0 200 OK\r\n");
			header.append("Content-Length: ").append(resp.getFileData().remaining()).append("\r\n");
			header.append("Connection: close\r\n");
			header.append("Server: Hyperion/1.0\r\n");
			header.append("Content-Type: " + resp.getMimeType() + "\r\n");
			header.append("\r\n");
		}
		byte[] headerBytes = header.toString().getBytes();
		ByteBuffer bb = resp.getFileData();
		ChannelBuffer ib = ChannelBuffers.buffer(bb.remaining() + headerBytes.length);
		ib.writeBytes(headerBytes);
		ib.writeBytes(bb);
		this.channel.write(ib).addListener(ChannelFutureListener.CLOSE); */
	}

	/**
	 * 
	 * @param resp
	 * 			The id to set.
	 */
	public void error404(Response resp) {
		StringBuilder header = new StringBuilder();
		if (this.getUpdateType() == UpdateType.HTTP) {
			header.append("HTTP/1.1 200 OK\r\n");
			header.append("Content-Length: ").append(resp.getFileBuffer().remaining()).append("\r\n");
			header.append("Connection: close\r\n");
			header.append("Server: Hyperion/1.0\r\n");
			header.append("Content-Type: " + resp.getMimeType() + "\r\n");
			header.append("\r\n");
		}
		byte[] headerBytes = header.toString().getBytes();
		ByteBuffer bb = resp.getFileBuffer();
		ChannelBuffer ib = ChannelBuffers.buffer(bb.remaining() + headerBytes.length);
		ib.writeBytes(headerBytes);
		ib.writeBytes(bb);
		this.getChannel().write(ib).addListener(ChannelFutureListener.CLOSE);
	}

	/**
	 * 
	 * @param line
	 * 			The id to set.
	 */
	public void readHTTPPath(String line) {
		String[] httpParts = line.split(" ");
		if (httpParts.length != 3) {
			this.getChannel().close();
		} else {
			this.setRequest(new Request(httpParts[1].trim()));
		}
	}

	/**
	 * 
	 * @param line
	 * 			The id to set.
	 */
	public void readJAGGRABPath(String line) {
		String jaggrab = "JAGGRAB ";
		if (line.startsWith(jaggrab)) {
			this.setRequest(new Request(line.substring(jaggrab.length()).trim()));
		} else {
			this.getChannel().close();
		}
		this.serve();
	}

	/**
	 * 
	 * @param channel
	 * 			The id to set.
	 */
	public void setChannel(Channel channel) {
		this.channel = channel;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public Channel getChannel() {
		return this.channel;
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

	/**
	 * 
	 * @param request
	 * 			The id to set.
	 */
	public void setRequest(Request request) {
		this.request = request;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public Request getRequest() {
		return this.request;
	}
}