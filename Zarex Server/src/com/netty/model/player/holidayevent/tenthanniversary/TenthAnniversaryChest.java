package com.netty.model.player.holidayevent.tenthanniversary;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 24, 2011 11:15:07 AM
 */
public class TenthAnniversaryChest {

	/**
	 * 
	 */
	private TenthAnniversaryCandle[] tenthAnniversaryCandles;

	/**
	 * 
	 */
	private TenthAnniversaryCake[] tenthAnniversaryCake;

	/**
	 * 
	 * @param tenthAnniversaryCandles
	 * 			The tenthAnniversaryCandles to set.
	 */
	public void setTenthAnniversaryCandles(TenthAnniversaryCandle[] tenthAnniversaryCandles) {
		this.tenthAnniversaryCandles = tenthAnniversaryCandles;
	}

	/**
	 * 
	 * @return tenthAnniversaryCandles
	 * 			Returns the tenthAnniversaryCandles to get.
	 */
	public TenthAnniversaryCandle[] getTenthAnniversaryCandles() {
		return this.tenthAnniversaryCandles;
	}

	/**
	 * 
	 * @param tenthAnniversaryCake
	 * 			The tenthAnniversaryCake to set.
	 */
	public void setTenthAnniversaryCake(TenthAnniversaryCake[] tenthAnniversaryCake) {
		this.tenthAnniversaryCake = tenthAnniversaryCake;
	}

	/**
	 * 
	 * @return tenthAnniversaryCake
	 * 			Returns the tenthAnniversaryCake to get.
	 */
	public TenthAnniversaryCake[] getTenthAnniversaryCake() {
		return this.tenthAnniversaryCake;
	}
}