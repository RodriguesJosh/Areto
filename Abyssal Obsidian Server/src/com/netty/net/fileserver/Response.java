package com.netty.net.fileserver;

import java.nio.ByteBuffer;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 21, 2011 1:20:27 PM
 */
public class Response {

	/**
	 * 
	 */
	private ByteBuffer fileBuffer;

	/**
	 * 
	 */
	private String mimeType;

	/**
	 * 
	 */
	private ResponseType responseType;

	/**
	 * 
	 * @param bytes
	 * 			The id to set.
	 * @param mimeType
	 * 			The id to set.
	 */
	public Response(byte[] bytes, String mimeType) {
		ByteBuffer fileBuffer = ByteBuffer.allocate(bytes.length);
		fileBuffer.put(bytes);
		fileBuffer.flip();
		this.setFileBuffer(fileBuffer);
		this.setMimeType(mimeType);
		this.setResponseType(ResponseType.OK);
	}

	/**
	 * 
	 * @param data
	 * 			The id to set.
	 * @param mimeType
	 * 			The id to set.
	 * @param responseType
	 * 			The id to set.
	 */
	public Response(ByteBuffer data, String mimeType, ResponseType responseType) {
		this(data, mimeType);
		this.setResponseType(responseType);
	}

	/**
	 * 
	 * @param string
	 * 			The id to set.
	 * @param mimeType
	 * 			The id to set.
	 */
	public Response(String string, String mimeType) {
		byte[] bytes = string.getBytes();
		ByteBuffer fileBuffer = ByteBuffer.allocate(bytes.length);
		fileBuffer.put(bytes);
		fileBuffer.flip();
		this.setFileBuffer(fileBuffer);
		this.setMimeType(mimeType);
		this.setResponseType(ResponseType.OK);
	}

	/**
	 * 
	 * @param fileBuffer
	 * 			The id to set.
	 * @param mimeType
	 * 			The id to set.
	 */
	public Response(ByteBuffer fileBuffer, String mimeType) {
		this.setFileBuffer(fileBuffer);
		this.setMimeType(mimeType);
		this.setResponseType(ResponseType.OK);
	}

	/**
	 * 
	 * @param fileBuffer
	 * 			The id to set.
	 */
	public void setFileBuffer(ByteBuffer fileBuffer) {
		this.fileBuffer = fileBuffer;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public ByteBuffer getFileBuffer() {
		return this.fileBuffer;
	}

	/**
	 * 
	 * @param mimeType
	 * 			The id to set.
	 */
	public void setMimeType(String mimeType) {
		this.mimeType = mimeType;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public String getMimeType() {
		return this.mimeType;
	}

	/**
	 * 
	 * @param responseType
	 * 			The id to set.
	 */
	public void setResponseType(ResponseType responseType) {
		this.responseType = responseType;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public ResponseType getResponseType() {
		return this.responseType;
	}
}