package com.netty.model.player.skill.construction;

public class Construction {

	private EstateAgent estateAgent;
	private HouseLocation houseLocation;
	private HouseState houseState;
	private HouseStyle houseStyle;
	private RoomType roomType;
	private Servant servant;

	public Construction() {

	}

	public void setEstateAgent(EstateAgent estateAgent) {
		this.estateAgent = estateAgent;
	}

	public EstateAgent getEstateAgent() {
		return this.estateAgent;
	}

	public void setHouseLocation(HouseLocation houseLocation) {
		this.houseLocation = houseLocation;
	}

	public HouseLocation getHouseLocation() {
		return this.houseLocation;
	}

	public void setHouseState(HouseState houseState) {
		this.houseState = houseState;
	}

	public HouseState getHouseState() {
		return this.houseState;
	}

	public void setHouseStyle(HouseStyle houseStyle) {
		this.houseStyle = houseStyle;
	}

	public HouseStyle getHouseStyle() {
		return this.houseStyle;
	}

	public void setRoomType(RoomType roomType) {
		this.roomType = roomType;
	}

	public RoomType getRoomType() {
		return this.roomType;
	}

	public void setServant(Servant servant) {
		this.servant = servant;
	}

	public Servant getServant() {
		return this.servant;
	}
}