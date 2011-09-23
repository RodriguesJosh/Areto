package com.mina.net;

import java.io.IOException;
import java.net.InetSocketAddress;

import org.apache.mina.core.service.IoAcceptor;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;

import com.netty.annotations.AnnotationType;
import com.netty.annotations.Edit;

/**
 * Boots up the connection for the MINA
 * networking API.
 * 
 * @author Joshua Rodrigues
 * @since Sep 19, 2011 12:42:15 AM
 */
@Edit(getAnnotationType = AnnotationType.EDIT)
public class BootMINA {

	/**
	 * An IoAcceptor to accept incoming
	 * connections from the client.
	 */
	private IoAcceptor ioAcceptor;

	/**
	 * Constructs a new boot up for the MINA
	 * networking API.
	 */
	public BootMINA() {
		this.setIOAcceptor(new NioSocketAcceptor());
	}

	/**
	 * Binds the connection to a specified
	 * port.
	 * 
	 * @param port
	 * 			The port to connect to.
	 */
	public void bindPort(int port) {
		this.getIOAcceptor().setHandler(new HandlerMINA());
		try {
			this.getIOAcceptor().bind(new InetSocketAddress(port));
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	/**
	 * Sets the IoAcceptor to accept connections
	 * with.
	 * 
	 * @param ioAcceptor
	 * 			The IoAcceptor to set.
	 */
	public void setIOAcceptor(IoAcceptor ioAcceptor) {
		this.ioAcceptor = ioAcceptor;
	}

	/**
	 * Gets the IoAcceptor for the player.
	 * 
	 * @return
	 * 			Returns the IoAcceptor for the
	 * 			player.
	 */
	public IoAcceptor getIOAcceptor() {
		return this.ioAcceptor;
	}
}