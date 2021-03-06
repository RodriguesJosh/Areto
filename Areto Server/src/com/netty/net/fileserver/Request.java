package com.netty.net.fileserver;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 21, 2011 1:20:59 PM
 */
public class Request {

	/**
	 * 
	 */
	private String path;

	/**
	 * 
	 * @param path
	 * 			The id to set.
	 */
	public Request(String path) {
		if (path.startsWith("/runescape") && path.endsWith(".pack200")) {
			this.setPath("/runescape.pack200");
		} else if (path.startsWith("/runescape") && path.endsWith(".js5")) {
			this.setPath("/runescape.js5");
		} else if (path.startsWith("/unpackclass") && path.endsWith(".pack")) {
			this.setPath("/unpackclass.pack");
		} else if (path.startsWith("/crc")) {
			this.setPath("/crc");
		} else if (path.startsWith("/config")) {
			this.setPath("/config");
		} else if (path.startsWith("/title")) {
			this.setPath("/title");
		} else if (path.startsWith("/interface")) {
			this.setPath("/interface");
		} else if (path.startsWith("/media")) {
			this.setPath("/media");
		} else if (path.startsWith("/sounds")) {
			this.setPath("/sounds");
		} else if (path.startsWith("/textures")) {
			this.setPath("/textures");
		} else if (path.startsWith("/versionlist")) {
			this.setPath("/versionlist");
		} else if (path.startsWith("/wordenc")) {
			this.setPath("/wordenc");
		} else {
			this.setPath(path);
		}
	}

	/**
	 * 
	 * @param path
	 * 			The id to set.
	 */
	public void setPath(String path) {
		this.path = path;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public String getPath() {
		return this.path;
	}
}