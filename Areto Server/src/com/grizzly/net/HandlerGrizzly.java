package com.grizzly.net;

import org.glassfish.grizzly.filterchain.BaseFilter;
import org.glassfish.grizzly.filterchain.FilterChainContext;
import org.glassfish.grizzly.filterchain.NextAction;

import com.netty.annotations.AnnotationType;
import com.netty.annotations.Edit;

/**
 * Handles the incoming connections from
 * each client.
 * 
 * @author Joshua Rodrigues
 * @since Sep 18, 2011 11:54:55 PM
 */
@Edit(getAnnotationType = AnnotationType.EDIT)
public class HandlerGrizzly extends BaseFilter {

	/*
	 * (non-Javadoc)
	 * @see org.glassfish.grizzly.filterchain.BaseFilter#handleConnect(org.glassfish.grizzly.filterchain.FilterChainContext)
	 */
	@Override
	public NextAction handleConnect(FilterChainContext fcc) {
		return fcc.getStopAction();
	}

	/*
	 * (non-Javadoc)
	 * @see org.glassfish.grizzly.filterchain.BaseFilter#handleRead(org.glassfish.grizzly.filterchain.FilterChainContext)
	 */
	@Override
	public NextAction handleRead(FilterChainContext fcc) {
		return fcc.getStopAction();
	}

	/*
	 * (non-Javadoc)
	 * @see org.glassfish.grizzly.filterchain.BaseFilter#handleClose(org.glassfish.grizzly.filterchain.FilterChainContext)
	 */
	@Override
	public NextAction handleClose(FilterChainContext fcc)  {
		this.close();
		return fcc.getStopAction();
	}

	/**
	 * This needs to be fixed up a bit.
	 */
	private void close() {
		this.handleClose(null);
	}
}