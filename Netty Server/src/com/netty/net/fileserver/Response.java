package com.netty.net.fileserver;

import java.nio.ByteBuffer;

public class Response {

	private ByteBuffer fileBuffer;
	private String mimeType;
	private ResponseType responseType;

	public Response(byte[] bytes, String mimeType) {
		ByteBuffer fileBuffer = ByteBuffer.allocate(bytes.length);
		fileBuffer.put(bytes);
		fileBuffer.flip();
		this.setFileBuffer(fileBuffer);
		this.setMimeType(mimeType);
		this.setResponseType(ResponseType.OK);
	}

	public Response(ByteBuffer data, String mimeType, ResponseType responseType) {
		this(data, mimeType);
		this.setResponseType(responseType);
	}

	public Response(String string, String mimeType) {
		byte[] bytes = string.getBytes();
		ByteBuffer fileBuffer = ByteBuffer.allocate(bytes.length);
		fileBuffer.put(bytes);
		fileBuffer.flip();
		this.setFileBuffer(fileBuffer);
		this.setMimeType(mimeType);
		this.setResponseType(ResponseType.OK);
	}

	public Response(ByteBuffer fileBuffer, String mimeType) {
		this.setFileBuffer(fileBuffer);
		this.setMimeType(mimeType);
		this.setResponseType(ResponseType.OK);
	}

	public void setFileBuffer(ByteBuffer fileBuffer) {
		this.fileBuffer = fileBuffer;
	}

	public ByteBuffer getFileBuffer() {
		return this.fileBuffer;
	}

	public void setMimeType(String mimeType) {
		this.mimeType = mimeType;
	}

	public String getMimeType() {
		return this.mimeType;
	}

	public void setResponseType(ResponseType responseType) {
		this.responseType = responseType;
	}

	public ResponseType getResponseType() {
		return this.responseType;
	}
}