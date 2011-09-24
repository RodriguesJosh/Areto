package com.netty.net.packet;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 21, 2011 1:14:52 PM
 */
public class PacketAttribute {

	/**
	 * 
	 */
	private ConcurrentMap<String, Object> attributeMap = new ConcurrentHashMap<String, Object>();

	/**
	 * 
	 */
	private PacketField[] packetField;

	/**
	 * 
	 * @param packetField
	 * 			The id to set.
	 */
	public PacketAttribute(PacketField[] packetField) {
		this.setPacketField(packetField);
	}

	/**
	 * 
	 * @param name
	 * 			The id to set.
	 * @param ifAbsent
	 * 			The id to set.
	 * @return
	 * 			The id to set.
	 */
	public Object getAttribute(String name, Object ifAbsent) {
		if (!this.hasAttribute(name)) {
			this.setAttribute(name, ifAbsent);
		}
		return this.getAttribute(name);
	}

	/**
	 * 
	 * @param name
	 * 			The id to set.
	 * @return
	 * 			The id to set.
	 */
	public Object getAttribute(String name) {
		return this.getAttributeMap().get(name);
	}

	/**
	 * 
	 * @param name
	 * 			The id to set.
	 * @param value
	 * 			The id to set.
	 */
	public void setAttribute(String name, Object value) {
		this.getAttributeMap().put(name, value);
	}

	/**
	 * 
	 * @param name
	 * 			The id to set.
	 * @return
	 * 			The id to set.
	 */
	public boolean hasAttribute(String name) {
		return this.getAttributeMap().containsKey(name);
	}

	/**
	 * 
	 * @param name
	 * 			The id to set.
	 */
	public void removeAttribute(String name) {
		this.getAttributeMap().remove(name);
	}

	/**
	 * 
	 * @param attributeMap
	 * 			The id to set.
	 */
	public void setAttributeMap(ConcurrentMap<String, Object> attributeMap) {
		this.attributeMap = attributeMap;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public ConcurrentMap<String, Object> getAttributeMap() {
		return this.attributeMap;
	}

	/**
	 * 
	 * @param packetField
	 * 			The id to set.
	 */
	public void setPacketField(PacketField[] packetField) {
		this.packetField = packetField;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public PacketField[] getPacketField() {
		return this.packetField;
	}
}