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

	public void setLocation(Location location) {
		this.location = location;
	}

	public Location getLocation() {
		return this.location;
	}

	public void setIndex(short index) {
		this.index = index;
	}

	public short getIndex() {
		return this.index;
	}

	public void setWalkingDirection(byte walkingDirection) {
		this.walkingDirection = walkingDirection;
	}

	public byte getWalkingDirection() {
		return this.walkingDirection;
	}

	public void setRunningDirection(byte runningDirection) {
		this.runningDirection = runningDirection;
	}

	public byte getRunningDirection() {
		return this.runningDirection;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getPass() {
		return this.pass;
	}

	public void setUpdateFlags(UpdateFlags updateFlags) {
		this.updateFlags = updateFlags;
	}

	public UpdateFlags getUpdateFlags() {
		return this.updateFlags;
	}

	public void setMapChanging(boolean isMapChanging) {
		this.isMapChanging = isMapChanging;
	}

	public boolean isMapChanging() {
		return this.isMapChanging;
	}

	public void resetMapChanging() {
		this.setMapChanging(false);
	}

	public void setWalking(Walking walking) {
		this.walking = walking;
	}

	public Walking getWalking() {
		return this.walking;
	}

	public boolean isWalking() {
		return this.getWalking() != null;
	}

	public void resetWalking() {
		this.setWalking(null);
	}

	public void setPlayerList(List<Player> playerList) {
		this.playerList = playerList;
	}

	public List<Player> getPlayerList() {
		return this.playerList;
	}

	public void setNPCList(List<NPC> npcList) {
		this.npcList = npcList;
	}

	public List<NPC> getNPCList() {
		return this.npcList;
	}

	public void setCombatLevel(short combatLevel) {
		this.combatLevel = combatLevel;
	}

	public short getCombatLevel() {
		return this.combatLevel;
	}

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

	public boolean isHovered() {
		return false;
	}

	public void setWidth(short width) {
		this.width = width;
	}

	public short getWidth() {
		return this.width;
	}

	public void setHeight(short height) {
		this.height = height;
	}

	public short getHeight() {
		return this.height;
	}

	public void setCombat(Combat combat) {
		this.combat = combat;
	}

	public Combat getCombat() {
		return this.combat;
	}

	public boolean isCombatting() {
		return this.getCombat() != null;
	}

	public void setAnimation(Animation animation) {
		this.animation = animation;
		if (animation != null) {
			this.getUpdateFlags().setUpdateFlag(UpdateFlag.ANIMATION);
		}
	}

	public Animation getAnimation() {
		return this.animation;
	}

	public boolean isAnimating() {
		return this.getAnimation() != null;
	}

	public void resetAnimation() {
		this.setAnimation(null);
	}

	public void setDead(boolean isDead) {
		this.isDead = isDead;
	}

	public boolean isDead() {
		return this.isDead;
	}

	public void setGraphic(Graphic graphic) {
		this.graphic = graphic;
		if (graphic != null) {
			this.getUpdateFlags().setUpdateFlag(UpdateFlag.GRAPHIC);
		}
	}

	public Graphic getGraphic() {
		return this.graphic;
	}

	public boolean isGraphicing() {
		return this.getGraphic() != null;
	}

	public void resetGraphic() {
		this.setGraphic(null);
	}

	public void setFaceEntity(FaceEntity faceEntity) {
		this.faceEntity = faceEntity;
		if (faceEntity != null) {
			this.getUpdateFlags().setUpdateFlag(UpdateFlag.FACE_ENTITY);
		}
	}

	public FaceEntity getFaceEntity() {
		return this.faceEntity;
	}

	public boolean isFacingEntity() {
		return this.getFaceEntity() != null;
	}

	public void resetFaceEntity() {
		this.setFaceEntity(null);
	}

	public void setForceMovement(ForceMovement forceMovement) {
		this.forceMovement = forceMovement;
		if (forceMovement != null) {
			this.getUpdateFlags().setUpdateFlag(UpdateFlag.FORCE_MOVEMENT);
		}
	}

	public ForceMovement getForceMovement() {
		return this.forceMovement;
	}

	public boolean isForceMovement() {
		return this.getForceMovement() != null;
	}

	public void resetForceMovement() {
		this.setForceMovement(null);
	}

	public void setFaceLocation(FaceLocation faceLocation) {
		this.faceLocation = faceLocation;
		if (faceLocation != null) {
			this.getUpdateFlags().setUpdateFlag(UpdateFlag.FACE_LOCATION);
		}
	}

	public FaceLocation getFaceLocation() {
		return this.faceLocation;
	}

	public boolean isFaceLocation() {
		return this.getFaceLocation() != null;
	}

	public void resetFaceLocation() {
		this.setFaceLocation(null);
	}

	public void setHit(Hit hit) {
		this.hit = hit;
		if (hit != null) {
			this.getUpdateFlags().setUpdateFlag(UpdateFlag.HIT);
		}
	}

	public Hit getHit() {
		return this.hit;
	}

	public boolean isHitting() {
		return this.getHit() != null;
	}

	public void resetHit() {
		this.setHit(null);
	}

	public void setHitTwo(HitTwo hitTwo) {
		this.hitTwo = hitTwo;
		if (hitTwo != null) {
			this.getUpdateFlags().setUpdateFlag(UpdateFlag.HIT_TWO);
		}
	}

	public HitTwo getHitTwo() {
		return this.hitTwo;
	}

	public boolean isHittingTwo() {
		return this.getHitTwo() != null;
	}

	public void resetHitTwo() {
		this.setHitTwo(null);
	}

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

	public ForceChat getForceChat() {
		return this.forceChat;
	}

	public boolean isForceChatting() {
		return this.getForceChat() != null;
	}

	public void resetForceChat() {
		this.setForceChat(null);
	}

	public void setLastLocation(Location lastLocation) {
		this.lastLocation = lastLocation;
	}

	public Location getLastLocation() {
		return this.lastLocation;
	}

	public void resetLastLocation() {
		this.setLastLocation(null);
	}

	public void setAttributeMap(Map<String, java.lang.Object> attributeMap) {
		this.attributeMap = attributeMap;
	}

	public Map<String, java.lang.Object> getAttributeMap() {
		return this.attributeMap;
	}

	public java.lang.Object getAttribute(String name, java.lang.Object ifAbsent) {
		if (!this.hasAttribute(name)) {
			this.setAttribute(name, ifAbsent);
		}
		return this.getAttribute(name);
	}

	public java.lang.Object getAttribute(String name) {
		return this.getAttributeMap().get(name);
	}

	public void setAttribute(String name, java.lang.Object value) {
		this.getAttributeMap().put(name, value);
	}

	public boolean hasAttribute(String name) {
		return this.getAttributeMap().containsKey(name);
	}

	public void removeAttribute(String name) {
		this.getAttributeMap().remove(name);
	}

	public void setHealth(byte health) {
		this.health = health;
	}

	public int getHealth() {
		return this.health;
	}

	public void setTeleport(Teleport teleport) {
		this.teleport = teleport;
		if (teleport != null) {
			this.setGraphic(new Graphic(308, 0));
		}
	}

	public Teleport getTeleport() {
		return this.teleport;
	}

	public boolean isTeleporting() {
		return this.getTeleport() != null;
	}

	public void resetTeleport() {
		this.setTeleport(null);
	}

	public void setID(int id) {
		this.id = id;
	}

	public int getID() {
		return this.id;
	}

	public void setDialogueList(DialogueList dialogueList) {
		this.dialogueList = dialogueList;
	}

	public DialogueList getDialogueList() {
		return this.dialogueList;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

	public Language getLanguage() {
		return this.language;
	}
}