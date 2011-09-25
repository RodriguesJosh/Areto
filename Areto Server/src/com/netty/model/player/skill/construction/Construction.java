package com.netty.model.player.skill.construction;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 22, 2011 1:07:02 PM
 */
public class Construction {

	/**
	 * 
	 */
	private EstateAgent estateAgent;

	/**
	 * 
	 */
	private HouseLocation houseLocation;

	/**
	 * 
	 */
	private HouseState houseState;

	/**
	 * 
	 */
	private HouseStyle houseStyle;

	/**
	 * 
	 */
	private RoomType roomType;

	/**
	 * 
	 */
	private Servant servant;

	/**
	 * 
	 */
	public Construction() {
		//
	}

	/**
	 * 
	 * @param estateAgent
	 * 			The id to set.
	 */
	public void setEstateAgent(EstateAgent estateAgent) {
		this.estateAgent = estateAgent;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public EstateAgent getEstateAgent() {
		return this.estateAgent;
	}

	/**
	 * 
	 * @param houseLocation
	 * 			The id to set.
	 */
	public void setHouseLocation(HouseLocation houseLocation) {
		this.houseLocation = houseLocation;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public HouseLocation getHouseLocation() {
		return this.houseLocation;
	}

	/**
	 * 
	 * @param houseState
	 * 			The id to set.
	 */
	public void setHouseState(HouseState houseState) {
		this.houseState = houseState;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public HouseState getHouseState() {
		return this.houseState;
	}

	/**
	 * 
	 * @param houseStyle
	 * 			The id to set.
	 */
	public void setHouseStyle(HouseStyle houseStyle) {
		this.houseStyle = houseStyle;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public HouseStyle getHouseStyle() {
		return this.houseStyle;
	}

	/**
	 * 
	 * @param roomType
	 * 			The id to set.
	 */
	public void setRoomType(RoomType roomType) {
		this.roomType = roomType;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public RoomType getRoomType() {
		return this.roomType;
	}

	/**
	 * 
	 * @param servant
	 * 			The id to set.
	 */
	public void setServant(Servant servant) {
		this.servant = servant;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public Servant getServant() {
		return this.servant;
	}
}