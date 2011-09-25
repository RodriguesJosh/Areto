package com.netty.model.player.donation;

import java.util.List;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 21, 2011 8:49:52 PM
 */
public class DonationManager {

	/**
	 * 
	 */
	private List<Donation> donationList;

	/**
	 * 
	 * @param donationList
	 * 			The donationList to set.
	 */
	public void setDonationList(List<Donation> donationList) {
		this.donationList = donationList;
	}

	/**
	 * 
	 * @return donationList
	 * 			Returns the donationList to get.
	 */
	public List<Donation> getDonationList() {
		return this.donationList;
	}
}