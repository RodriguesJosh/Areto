package com.netty.game.model.update;

import java.util.BitSet;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 25, 2011 3:00:10 PM
 */
public class UpdateFlags {

	/**
	 * 
	 */
	private BitSet updateFlags;

	/**
	 * 
	 */
	public UpdateFlags() {
		this.setUpdateFlags(new BitSet());
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public boolean isUpdateRequired() {
		return !this.getUpdateFlags().isEmpty();
	}

	/**
	 * 
	 * @param updateFlag
	 * 			The id to set.
	 */
	public void setUpdateFlag(UpdateFlag updateFlag) {
		this.getUpdateFlags().set(updateFlag.ordinal(), true);
	}

	/**
	 * 
	 * @param updateFlag
	 * 			The id to set.
	 * @param value
	 * 			The id to set.
	 */
	public void setUpdateFlag(UpdateFlag updateFlag, boolean value) {
		this.getUpdateFlags().set(updateFlag.ordinal(), value);
	}

	/**
	 * 
	 * @param updateFlag
	 * 			The id to set.
	 * @return
	 * 			The id to set.
	 */
	public boolean getUpdateFlag(UpdateFlag updateFlag) {
		return this.getUpdateFlags().get(updateFlag.ordinal());
	}

	/**
	 * 
	 */
	public void resetUpdateFlags() {
		this.getUpdateFlags().clear();
	}

	/**
	 * 
	 * @param updateFlags
	 * 			The id to set.
	 */
	public void setUpdateFlags(BitSet updateFlags) {
		this.updateFlags = updateFlags;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public BitSet getUpdateFlags() {
		return this.updateFlags;
	}
}