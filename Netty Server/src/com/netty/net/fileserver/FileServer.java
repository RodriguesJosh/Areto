package com.netty.net.fileserver;

import com.netty.net.fileserver.http.HTTP;
import com.netty.net.fileserver.jaggrab.JAGGRAB;

public class FileServer {

	private HTTP http;
	private JAGGRAB jaggrab;

	public FileServer() {
		this.setHTTP(new HTTP());
		this.setJAGGRAB(new JAGGRAB());
	}

	public void setHTTP(HTTP http) {
		this.http = http;
	}

	public HTTP getHTTP() {
		return this.http;
	}

	public void setJAGGRAB(JAGGRAB jaggrab) {
		this.jaggrab = jaggrab;
	}

	public JAGGRAB getJAGGRAB() {
		return this.jaggrab;
	}
}