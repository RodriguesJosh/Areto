package com.io.net;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

import com.netty.net.NetworkConstants;

/**
 * Boots up the connection for the standard
 * IO API.
 * 
 * @author Joshua Rodrigues
 * @since Sep 19, 2011 12:12:47 AM
 */
public class BootIO {

	/**
	 * A ServerSocket instance for accepting a
	 * Socket connection.
	 */
	private ServerSocket serverSocket;

	/**
	 * Constructs a new BootIO and binds the port
	 * to the specified one.
	 */
	public BootIO() {
		try {
			this.setServerSocket(new ServerSocket(NetworkConstants.PORT, 1, null));
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	/**
	 * Bind the port to the parameter.
	 */
	public void bindPort() {
		Socket socket = null;
		try {
			socket = this.getServerSocket().accept();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		try {
			if (socket == null) {
				return;
			}
			socket.setTcpNoDelay(true);
		} catch (SocketException se) {
			se.printStackTrace();
		}
	}

	/**
	 * Sets a new ServerSocket for the BootIO
	 * to use when connecting to the client.
	 * 
	 * @param serverSocket
	 * 			The ServerSocket for connection.
	 */
	public void setServerSocket(ServerSocket serverSocket) {
		this.serverSocket = serverSocket;
	}

	/**
	 * Gets the ServerSocket to use for Socket
	 * purposes.
	 * 
	 * @return serverSocket
	 * 			The ServerSocket for connection.
	 */
	public ServerSocket getServerSocket() {
		return this.serverSocket;
	}
}