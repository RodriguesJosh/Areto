package com.netty.net.fileserver;

import com.netty.net.fileserver.http.HTTP;
import com.netty.net.fileserver.jaggrab.JAGGRAB;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 21, 2011 1:22:43 PM
 */
public class FileServer {

	/**
	 * 
	 */
	private HTTP http;

	/**
	 * 
	 */
	private JAGGRAB jaggrab;

	/**
	 * 
	 */
	public FileServer() {
		this.setHTTP(new HTTP());
		this.setJAGGRAB(new JAGGRAB());
	}

	/**
	 * 
	 * @param http
	 * 			The id to set.
	 */
	public void setHTTP(HTTP http) {
		this.http = http;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public HTTP getHTTP() {
		return this.http;
	}

	/**
	 * 
	 * @param jaggrab
	 * 			The id to set.
	 */
	public void setJAGGRAB(JAGGRAB jaggrab) {
		this.jaggrab = jaggrab;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public JAGGRAB getJAGGRAB() {
		return this.jaggrab;
	}
}