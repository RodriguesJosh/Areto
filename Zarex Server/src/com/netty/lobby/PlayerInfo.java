package com.netty.lobby;

public class PlayerInfo {

	private String ipAddress;
	private boolean emailRegistration;
	private boolean recoveryQuestions;
	private boolean messages;
	private boolean membership;

	public PlayerInfo(String ipAddress, boolean emailRegistration, boolean recoveryQuestions, boolean messages, boolean membership) {
		this.setIPAddress(ipAddress);
		this.setEmailRegistration(emailRegistration);
		this.setRecoveryQuestions(recoveryQuestions);
		this.setMessages(messages);
		this.setMembership(membership);
	}

	public void setIPAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public String getIPAddress() {
		return this.ipAddress;
	}

	public void setEmailRegistration(boolean emailRegistration) {
		this.emailRegistration = emailRegistration;
	}

	public boolean isEmailRegistration() {
		return this.emailRegistration;
	}

	public void setRecoveryQuestions(boolean recoveryQuestions) {
		this.recoveryQuestions = recoveryQuestions;
	}

	public boolean isRecoveryQuestions() {
		return this.recoveryQuestions;
	}

	public void setMessages(boolean messages) {
		this.messages = messages;
	}

	public boolean isMessages() {
		return this.messages;
	}

	public void setMembership(boolean membership) {
		this.membership = membership;
	}

	public boolean isMembership() {
		return this.membership;
	}
}