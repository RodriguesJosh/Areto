package com.mina.net;

import java.io.IOException;
import java.net.InetSocketAddress;

import org.apache.mina.core.service.IoAcceptor;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;

public class BootMINA {

	private IoAcceptor ioAcceptor;

	public BootMINA() {
		this.setIOAcceptor(new NioSocketAcceptor());
	}

	public void bindPort(int port) {
		this.getIOAcceptor().setHandler(new HandlerMINA());
		try {
			this.getIOAcceptor().bind(new InetSocketAddress(port));
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	public void setIOAcceptor(IoAcceptor ioAcceptor) {
		this.ioAcceptor = ioAcceptor;
	}

	public IoAcceptor getIOAcceptor() {
		return this.ioAcceptor;
	}
}