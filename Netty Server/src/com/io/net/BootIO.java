package com.io.net;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

import com.netty.net.NetworkConstants;

/**
 * Boots up the connection for the
 * standard IO API.
 * @author Josh Rodrigues
 * @since September 18, 2011
 */
public class BootIO {

	/**
	 * A {@code ServerSocket} instance for accepting
	 * a {@code Socket} connection.
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
	 * @param port
	 * 			The port to bind with.
	 */
	public void bindPort(int port) {
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
	 * Sets a new {@code ServerSocket} for the BootIO
	 * to use when connecting to the client.
	 * @param serverSocket
	 * 			The {@code ServerSocket} for connection.
	 */
	public void setServerSocket(ServerSocket serverSocket) {
		this.serverSocket = serverSocket;
	}

	/**
	 * Gets the {@code ServerSocket} to use for {@code Socket}
	 * purposes.
	 * @return serverSocket
	 * 			The {@code ServerSocket} for connection.
	 */
	public ServerSocket getServerSocket() {
		return this.serverSocket;
	}
}