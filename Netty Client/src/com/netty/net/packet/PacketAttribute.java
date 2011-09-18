package com.netty.net.packet;

import java.util.HashMap;
import java.util.Map;

public class PacketAttribute {

	private Map<String, Object> attributes = new HashMap<String, Object>();
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
		return this.getAttributes().get(name);
	}

	public void setAttribute(String name, Object value) {
		this.getAttributes().put(name, value);
	}

	public boolean hasAttribute(String name) {
		return this.getAttributes().containsKey(name);
	}

	public void removeAttribute(String name) {
		this.getAttributes().remove(name);
	}

	public void setAttributes(Map<String, Object> attributes) {
		this.attributes = attributes;
	}

	public Map<String, Object> getAttributes() {
		return this.attributes;
	}

	public void setPacketField(PacketField[] packetField) {
		this.packetField = packetField;
	}

	public PacketField[] getPacketField() {
		return this.packetField;
	}
}