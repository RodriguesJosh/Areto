package com.netty.net.packet;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class PacketAttribute {

	private ConcurrentMap<String, Object> attributeMap = new ConcurrentHashMap<String, Object>();
	private PacketField[] packetField;

	public PacketAttribute(PacketField[] packetField) {
		this.setPacketField(packetField);
	}

	public Object getAttribute(String name, Object ifAbsent) {
		if (!this.hasAttribute(name)) {
			this.setAttribute(name, ifAbsent);
		}
		return this.getAttribute(name);
	}

	public Object getAttribute(String name) {
		return this.getAttributeMap().get(name);
	}

	public void setAttribute(String name, Object value) {
		this.getAttributeMap().put(name, value);
	}

	public boolean hasAttribute(String name) {
		return this.getAttributeMap().containsKey(name);
	}

	public void removeAttribute(String name) {
		this.getAttributeMap().remove(name);
	}

	public void setAttributeMap(ConcurrentMap<String, Object> attributeMap) {
		this.attributeMap = attributeMap;
	}

	public ConcurrentMap<String, Object> getAttributeMap() {
		return this.attributeMap;
	}

	public void setPacketField(PacketField[] packetField) {
		this.packetField = packetField;
	}

	public PacketField[] getPacketField() {
		return this.packetField;
	}
}