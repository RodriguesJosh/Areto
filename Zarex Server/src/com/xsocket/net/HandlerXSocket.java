package com.xsocket.net;

import org.xsocket.connection.IConnectHandler;
import org.xsocket.connection.IDataHandler;
import org.xsocket.connection.IDisconnectHandler;
import org.xsocket.connection.INonBlockingConnection;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 21, 2011 11:51:35 AM
 */
public class HandlerXSocket implements IConnectHandler, IDataHandler, IDisconnectHandler {

	/* (non-Javadoc)
	 * @see org.xsocket.connection.IConnectHandler#onConnect(org.xsocket.connection.INonBlockingConnection)
	 */
	@Override
	public boolean onConnect(INonBlockingConnection inbc) {
		return false;
	}

	/* (non-Javadoc)
	 * @see org.xsocket.connection.IDataHandler#onData(org.xsocket.connection.INonBlockingConnection)
	 */
	@Override
	public boolean onData(INonBlockingConnection arg0) {
		return false;
	}

	/* (non-Javadoc)
	 * @see org.xsocket.connection.IDisconnectHandler#onDisconnect(org.xsocket.connection.INonBlockingConnection)
	 */
	@Override
	public boolean onDisconnect(INonBlockingConnection arg0) {
		return false;
	}
}