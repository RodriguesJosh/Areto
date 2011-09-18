package com.netty.game.model.update;

import java.util.BitSet;

public class UpdateFlags {

	private BitSet updateFlags;

	public UpdateFlags() {
		this.setUpdateFlags(new BitSet());
	}

	public boolean isUpdateRequired() {
		return !this.getUpdateFlags().isEmpty();
	}

	public void setUpdateFlag(UpdateFlag updateFlag) {
		this.getUpdateFlags().set(updateFlag.ordinal(), true);
	}

	public void setUpdateFlag(UpdateFlag updateFlag, boolean value) {
		this.getUpdateFlags().set(updateFlag.ordinal(), value);
	}

	public boolean getUpdateFlag(UpdateFlag updateFlag) {
		return this.getUpdateFlags().get(updateFlag.ordinal());
	}

	public void resetUpdateFlags() {
		this.getUpdateFlags().clear();
	}

	public void setUpdateFlags(BitSet updateFlags) {
		this.updateFlags = updateFlags;
	}

	public BitSet getUpdateFlags() {
		return this.updateFlags;
	}
}