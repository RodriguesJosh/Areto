package com.netty.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.api.translate.Language;
import com.netty.model.combat.AttackType;
import com.netty.model.combat.Combat;
import com.netty.model.combat.CombatType;
import com.netty.model.combat.MeleeCombat;
import com.netty.model.item.Item;
import com.netty.model.npc.NPC;
import com.netty.model.object.Object;
import com.netty.model.player.Player;
import com.netty.model.player.Teleport;
import com.netty.model.player.dialogue.DialogueList;
import com.netty.model.update.Animation;
import com.netty.model.update.FaceEntity;
import com.netty.model.update.FaceLocation;
import com.netty.model.update.ForceChat;
import com.netty.model.update.ForceMovement;
import com.netty.model.update.Graphic;
import com.netty.model.update.Hit;
import com.netty.model.update.HitTwo;
import com.netty.model.update.UpdateFlag;
import com.netty.model.update.UpdateFlags;
import com.netty.world.Location;

/**
 * 
 * 
 * @author Joshua Rodrigues
 * @since Sep 20, 2011 7:50:57 PM
 */
public abstract class Entity {

	private Location location;
	private short index;
	private byte walkingDirection;
	private byte runningDirection;
	private String name;
	private String pass;
	private UpdateFlags updateFlags;
	private boolean isMapChanging;
	private Walking walking;
	private List<Player> playerList;
	private List<NPC> npcList;
	private short combatLevel;
	private short width;
	private short height;
	private Combat combat;
	private Animation animation;
	private boolean isDead;
	private Graphic graphic;
	private FaceEntity faceEntity;
	private ForceMovement forceMovement;
	private FaceLocation faceLocation;
	private Hit hit;
	private HitTwo hitTwo;
	private ForceChat forceChat;
	private Location lastLocation;
	private Map<String, java.lang.Object> attributeMap;
	private byte health;
	private Teleport teleport;
	private int id;
	private DialogueList dialogueList;
	private Language language;

	/**
	 * 
	 */
	public Entity() {
		this.setWalkingDirection((byte) -1);
		this.setRunningDirection((byte) -1);
		this.setUpdateFlags(new UpdateFlags());
		this.setWalking(new Walking(this));
		this.setPlayerList(new ArrayList<Player>());
		this.setNPCList(new ArrayList<NPC>());
		this.setCombat(new MeleeCombat((Player) this, this, CombatType.MELEE, AttackType.ACCURATE));
		this.setTeleport(Teleport.HOME);
		this.setLocation(this.getTeleport().getTeleportingLocation());
		this.setLastLocation(this.getLocation());
		this.setAttributeMap(new HashMap<String, java.lang.Object>());
		this.setDialogueList(new DialogueList(this));
		this.setLanguage(Language.ENGLISH);
	}

	/**
	 * 
	 * @param location
	 * 			The location to set.
	 */
	public void setLocation(Location location) {
		this.location = location;
	}

	/**
	 * 
	 * @return location
	 */
	public Location getLocation() {
		return this.location;
	}

	/**
	 * 
	 * @param index
	 * 			The index to set.
	 */
	public void setIndex(short index) {
		this.index = index;
	}

	/**
	 * 
	 * @return index
	 */
	public short getIndex() {
		return this.index;
	}

	/**
	 * 
	 * @param walkingDirection
	 * 			The walking direction to set.
	 */
	public void setWalkingDirection(byte walkingDirection) {
		this.walkingDirection = walkingDirection;
	}

	/**
	 * 
	 * @return walkingDirection
	 */
	public byte getWalkingDirection() {
		return this.walkingDirection;
	}

	/**
	 * 
	 * @param runningDirection
	 * 			The running direction to set.
	 */
	public void setRunningDirection(byte runningDirection) {
		this.runningDirection = runningDirection;
	}

	/**
	 * 
	 * @return runningDirection
	 */
	public byte getRunningDirection() {
		return this.runningDirection;
	}

	/**
	 * 
	 * @param name
	 * 			The name to set.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 
	 * @return name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * 
	 * @param pass
	 * 			The pass to set.
	 */
	public void setPass(String pass) {
		this.pass = pass;
	}

	/**
	 * 
	 * @return pass
	 */
	public String getPass() {
		return this.pass;
	}

	/**
	 * 
	 * @param updateFlags
	 * 			The update flags to set.
	 */
	public void setUpdateFlags(UpdateFlags updateFlags) {
		this.updateFlags = updateFlags;
	}

	/**
	 * 
	 * @return updateFlags
	 */
	public UpdateFlags getUpdateFlags() {
		return this.updateFlags;
	}

	/**
	 * 
	 * @param isMapChanging
	 * 			The map changing to set.
	 */
	public void setMapChanging(boolean isMapChanging) {
		this.isMapChanging = isMapChanging;
	}

	/**
	 * 
	 * @return isMapChanging
	 */
	public boolean isMapChanging() {
		return this.isMapChanging;
	}

	/**
	 * 
	 */
	public void resetMapChanging() {
		this.setMapChanging(false);
	}

	/**
	 * 
	 * @param walking
	 * 			The walking to set.
	 */
	public void setWalking(Walking walking) {
		this.walking = walking;
	}

	/**
	 * 
	 * @return walking
	 */
	public Walking getWalking() {
		return this.walking;
	}

	/**
	 * 
	 * @return walking
	 */
	public boolean isWalking() {
		return this.getWalking() != null;
	}

	/**
	 * 
	 */
	public void resetWalking() {
		this.setWalking(null);
	}

	/**
	 * 
	 * @param playerList
	 * 			The player list to set.
	 */
	public void setPlayerList(List<Player> playerList) {
		this.playerList = playerList;
	}

	/**
	 * 
	 * @return playerList
	 */
	public List<Player> getPlayerList() {
		return this.playerList;
	}

	/**
	 * 
	 * @param npcList
	 * 			The NPC list to set.
	 */
	public void setNPCList(List<NPC> npcList) {
		this.npcList = npcList;
	}

	/**
	 * 
	 * @return npcList
	 */
	public List<NPC> getNPCList() {
		return this.npcList;
	}

	/**
	 * 
	 * @param combatLevel
	 * 			The combat level to set.
	 */
	public void setCombatLevel(short combatLevel) {
		this.combatLevel = combatLevel;
	}

	/**
	 * 
	 * @return combatLevel
	 */
	public short getCombatLevel() {
		return this.combatLevel;
	}

	/**
	 * 
	 * @return false
	 */
	public boolean isClicked() {
		if (this instanceof NPC) {
			NPC npc = (NPC) this;
			return (this.getLocation().getX() > npc.getLocation().getX()) && (this.getLocation().getX() < (npc.getLocation().getX() + this.getWidth())) && (this.getLocation().getY() > npc.getLocation().getY()) && (this.getLocation().getY() < (npc.getLocation().getY() + this.getHeight()));
		} else if (this instanceof Player) {
			Player player = (Player) this;
			return (this.getLocation().getX() > player.getLocation().getX()) && (this.getLocation().getX() < (player.getLocation().getX() + this.getWidth())) && (this.getLocation().getY() > player.getLocation().getY()) && (this.getLocation().getY() < (player.getLocation().getY() + this.getHeight()));
		} else if (this instanceof Object) {
			Object object = (Object) this;
			return (this.getLocation().getX() > object.getLocation().getX()) && (this.getLocation().getX() < (object.getLocation().getX() + this.getWidth())) && (this.getLocation().getY() > object.getLocation().getY()) && (this.getLocation().getY() < (object.getLocation().getY() + this.getHeight()));
		} else if (this instanceof Item) {
			Item item = (Item) this;
			return (this.getLocation().getX() > item.getLocation().getX()) && (this.getLocation().getX() < (item.getLocation().getX() + this.getWidth())) && (this.getLocation().getY() > item.getLocation().getY()) && (this.getLocation().getY() < (item.getLocation().getY() + this.getHeight()));
		}
		return false;
	}

	/**
	 * 
	 * @return false
	 */
	public boolean isHovered() {
		return false;
	}

	/**
	 * 
	 * @param width
	 * 			The width to set.
	 */
	public void setWidth(short width) {
		this.width = width;
	}

	/**
	 * 
	 * @return width
	 */
	public short getWidth() {
		return this.width;
	}

	/**
	 * 
	 * @param height
	 * 			The height to set.
	 */
	public void setHeight(short height) {
		this.height = height;
	}

	/**
	 * 
	 * @return height
	 */
	public short getHeight() {
		return this.height;
	}

	/**
	 * 
	 * @param combat
	 * 			The combat to set.
	 */
	public void setCombat(Combat combat) {
		this.combat = combat;
	}

	/**
	 * 
	 * @return combat
	 */
	public Combat getCombat() {
		return this.combat;
	}

	/**
	 * 
	 * @return combat
	 */
	public boolean isCombatting() {
		return this.getCombat() != null;
	}

	/**
	 * 
	 * @param animation
	 * 			The animation to set.
	 */
	public void setAnimation(Animation animation) {
		this.animation = animation;
		if (animation != null) {
			this.getUpdateFlags().setUpdateFlag(UpdateFlag.ANIMATION);
		}
	}

	/**
	 * 
	 * @return animation
	 */
	public Animation getAnimation() {
		return this.animation;
	}

	/**
	 * 
	 * @return animation
	 */
	public boolean isAnimating() {
		return this.getAnimation() != null;
	}

	/**
	 * 
	 */
	public void resetAnimation() {
		this.setAnimation(null);
	}

	/**
	 * 
	 * @param isDead
	 * 			The dead to set.
	 */
	public void setDead(boolean isDead) {
		this.isDead = isDead;
	}

	/**
	 * 
	 * @return isDead
	 */
	public boolean isDead() {
		return this.isDead;
	}

	/**
	 * 
	 * @param graphic
	 * 			The graphic to set.
	 */
	public void setGraphic(Graphic graphic) {
		this.graphic = graphic;
		if (graphic != null) {
			this.getUpdateFlags().setUpdateFlag(UpdateFlag.GRAPHIC);
		}
	}

	/**
	 * 
	 * @return graphic
	 */
	public Graphic getGraphic() {
		return this.graphic;
	}

	/**
	 * 
	 * @return graphic
	 */
	public boolean isGraphicing() {
		return this.getGraphic() != null;
	}

	/**
	 * 
	 */
	public void resetGraphic() {
		this.setGraphic(null);
	}

	/**
	 * 
	 * @param faceEntity
	 * 			The facing of the entity to set.
	 */
	public void setFaceEntity(FaceEntity faceEntity) {
		this.faceEntity = faceEntity;
		if (faceEntity != null) {
			this.getUpdateFlags().setUpdateFlag(UpdateFlag.FACE_ENTITY);
		}
	}

	/**
	 * 
	 * @return faceEntity
	 */
	public FaceEntity getFaceEntity() {
		return this.faceEntity;
	}

	/**
	 * 
	 * @return face entity
	 */
	public boolean isFacingEntity() {
		return this.getFaceEntity() != null;
	}

	/**
	 * 
	 */
	public void resetFaceEntity() {
		this.setFaceEntity(null);
	}

	/**
	 * 
	 * @param forceMovement
	 * 			The forcing of the movement to set.
	 */
	public void setForceMovement(ForceMovement forceMovement) {
		this.forceMovement = forceMovement;
		if (forceMovement != null) {
			this.getUpdateFlags().setUpdateFlag(UpdateFlag.FORCE_MOVEMENT);
		}
	}

	/**
	 * 
	 * @return forceMovement
	 */
	public ForceMovement getForceMovement() {
		return this.forceMovement;
	}

	/**
	 * 
	 * @return forceMovement
	 */
	public boolean isForceMovement() {
		return this.getForceMovement() != null;
	}

	/**
	 * 
	 */
	public void resetForceMovement() {
		this.setForceMovement(null);
	}

	/**
	 * 
	 * @param faceLocation
	 * 			The facing of location to set.
	 */
	public void setFaceLocation(FaceLocation faceLocation) {
		this.faceLocation = faceLocation;
		if (faceLocation != null) {
			this.getUpdateFlags().setUpdateFlag(UpdateFlag.FACE_LOCATION);
		}
	}

	/**
	 * 
	 * @return faceLocation
	 */
	public FaceLocation getFaceLocation() {
		return this.faceLocation;
	}

	/**
	 * 
	 * @return faceLocation
	 */
	public boolean isFaceLocation() {
		return this.getFaceLocation() != null;
	}

	/**
	 * 
	 */
	public void resetFaceLocation() {
		this.setFaceLocation(null);
	}

	/**
	 * 
	 * @param hit
	 * 			The hit to set.
	 */
	public void setHit(Hit hit) {
		this.hit = hit;
		if (hit != null) {
			this.getUpdateFlags().setUpdateFlag(UpdateFlag.HIT);
		}
	}

	/**
	 * 
	 * @return hit
	 */
	public Hit getHit() {
		return this.hit;
	}

	/**
	 * 
	 * @return hit
	 */
	public boolean isHitting() {
		return this.getHit() != null;
	}

	/**
	 * 
	 */
	public void resetHit() {
		this.setHit(null);
	}

	/**
	 * 
	 * @param hitTwo
	 * 			The hit two to set.
	 */
	public void setHitTwo(HitTwo hitTwo) {
		this.hitTwo = hitTwo;
		if (hitTwo != null) {
			this.getUpdateFlags().setUpdateFlag(UpdateFlag.HIT_TWO);
		}
	}

	/**
	 * 
	 * @return hitTwo
	 */
	public HitTwo getHitTwo() {
		return this.hitTwo;
	}

	/**
	 * 
	 * @return hitTwo
	 */
	public boolean isHittingTwo() {
		return this.getHitTwo() != null;
	}

	/**
	 * 
	 */
	public void resetHitTwo() {
		this.setHitTwo(null);
	}

	/**
	 * 
	 * @param forceChat
	 * 			The forced chat to set.
	 */
	public void setForceChat(ForceChat forceChat) {
		if (forceChat == null) {
			return;
		}
		if (forceChat.getForceText().equals("")) {
			return;
		}
		this.forceChat = forceChat;
		this.getUpdateFlags().setUpdateFlag(UpdateFlag.FORCE_CHAT);
	}

	/**
	 * 
	 * @return forceChat
	 */
	public ForceChat getForceChat() {
		return this.forceChat;
	}

	/**
	 * 
	 * @return forceChat
	 */
	public boolean isForceChatting() {
		return this.getForceChat() != null;
	}

	/**
	 * 
	 */
	public void resetForceChat() {
		this.setForceChat(null);
	}

	/**
	 * 
	 * @param lastLocation
	 * 			The last location to set.
	 */
	public void setLastLocation(Location lastLocation) {
		this.lastLocation = lastLocation;
	}

	/**
	 * 
	 * @return lastLocation
	 */
	public Location getLastLocation() {
		return this.lastLocation;
	}

	/**
	 * 
	 */
	public void resetLastLocation() {
		this.setLastLocation(null);
	}

	/**
	 * 
	 * @param attributeMap
	 * 			The attribute map to set.
	 */
	public void setAttributeMap(Map<String, java.lang.Object> attributeMap) {
		this.attributeMap = attributeMap;
	}

	/**
	 * 
	 * @return attributeMap
	 */
	public Map<String, java.lang.Object> getAttributeMap() {
		return this.attributeMap;
	}

	/**
	 * 
	 * @param name
	 * 			The name to set.
	 * @param ifAbsent
	 * 			The if absent to set.
	 * @return false
	 */
	public java.lang.Object getAttribute(String name, java.lang.Object ifAbsent) {
		if (!this.hasAttribute(name)) {
			this.setAttribute(name, ifAbsent);
		}
		return this.getAttribute(name);
	}

	/**
	 * 
	 * @param name
	 * 			The name to set.
	 * @return false
	 */
	public java.lang.Object getAttribute(String name) {
		return this.getAttributeMap().get(name);
	}

	/**
	 * 
	 * @param name
	 * 			The name to set.
	 * @param value
	 * 			The value to set.
	 */
	public void setAttribute(String name, java.lang.Object value) {
		this.getAttributeMap().put(name, value);
	}

	/**
	 * 
	 * @param name
	 * 			The name to set.
	 * @return false
	 */
	public boolean hasAttribute(String name) {
		return this.getAttributeMap().containsKey(name);
	}

	/**
	 * 
	 * @param name
	 * 			The name to set.
	 */
	public void removeAttribute(String name) {
		this.getAttributeMap().remove(name);
	}

	/**
	 * 
	 * @param health
	 * 			The health to set.
	 */
	public void setHealth(byte health) {
		this.health = health;
	}

	/**
	 * 
	 * @return health
	 */
	public int getHealth() {
		return this.health;
	}

	/**
	 * 
	 * @param teleport
	 * 			The teleport to set.
	 */
	public void setTeleport(Teleport teleport) {
		this.teleport = teleport;
		if (teleport != null) {
			this.setGraphic(new Graphic(308, 0));
		}
	}

	/**
	 * 
	 * @return teleport
	 */
	public Teleport getTeleport() {
		return this.teleport;
	}

	/**
	 * 
	 * @return teleport
	 */
	public boolean isTeleporting() {
		return this.getTeleport() != null;
	}

	/**
	 * 
	 */
	public void resetTeleport() {
		this.setTeleport(null);
	}

	/**
	 * 
	 * @param id
	 * 			The id to set.
	 */
	public void setID(int id) {
		this.id = id;
	}

	/**
	 * 
	 * @return id
	 */
	public int getID() {
		return this.id;
	}

	/**
	 * 
	 * @param dialogueList
	 * 			The dialogue list to set.
	 */
	public void setDialogueList(DialogueList dialogueList) {
		this.dialogueList = dialogueList;
	}

	/**
	 * 
	 * @return dialogueList
	 */
	public DialogueList getDialogueList() {
		return this.dialogueList;
	}

	/**
	 * 
	 * @param language
	 * 			The language to set.
	 */
	public void setLanguage(Language language) {
		this.language = language;
	}

	/**
	 * 
	 * @return language
	 */
	public Language getLanguage() {
		return this.language;
	}
}