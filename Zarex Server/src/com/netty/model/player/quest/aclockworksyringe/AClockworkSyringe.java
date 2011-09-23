package com.netty.model.player.quest.aclockworksyringe;

import com.netty.model.combat.AttackType;
import com.netty.model.combat.CombatType;
import com.netty.model.combat.melee.MeleeCombat;
import com.netty.model.player.Player;
import com.netty.model.player.quest.Quest;
import com.netty.model.player.quest.QuestStage;
import com.netty.model.player.quest.QuestType;
import com.netty.model.update.ForceChat;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 22, 2011 3:15:59 PM
 */
public class AClockworkSyringe extends Quest {

	/**
	 * 
	 */
	private PostiePete postiePete;

	/**
	 * 
	 */
	private BarrelchestMkII barrelchestMkII;

	/**
	 * 
	 */
	private EstateAgent estateAgent;

	/**
	 * 
	 */
	private ZombieStressLevel zombieStressLevel;

	/**
	 * 
	 * @param name
	 * 			The id to set.
	 * @param player
	 * 			The id to set.
	 * @param questStage
	 * 			The id to set.
	 * @param questType
	 * 			The id to set.
	 */
	public AClockworkSyringe(String name, Player player, QuestStage questStage, QuestType questType) {
		super(name, player, questStage, questType);
		// Start it with the dialogue.
		this.setPostiePete(new PostiePete(player));
		ForceChat forceChat = new ForceChat("Not if I see you first!");
		this.getPostiePete().setSecondForceChat(forceChat);
		// Options (somehow..)
		// "Go to your house."
		// "Go to your house (building mode)."
		// "Go to a friend's house."
		// "A Clockwork Syringe."
		// "Never mind."
		// "There is a delivery note stuck to the portal, addressed
		// to you."
		// New options..
		// "Take the delivery note?"
		// Yes, no.
		// "You take it and put it in your pack."
		// Add scroll thing to inventory and it opens an interface.
		// "WARNING"
		// "Some players may find the following scene distressing."
		// "There are no kitten cutscenes to protect your innocence this time."
		// New..
		// "Investigate the mystery package?"
		// Yes, no.
		// Create the action for "Investigate Large crate"
		// "Investigate the myserious package?"
		// Yes, no.
		this.setBarrelchestMkII(new BarrelchestMkII());
		ForceChat secondForceChat = new ForceChat("Surprise, " + player.getName());
		this.getBarrelchestMkII().setSecondForceChat(secondForceChat);
		if (player.isMeleeing()) {
			player.setCombat(new MeleeCombat(player, this.getBarrelchestMkII().getNPC(), CombatType.MELEE, AttackType.ACCURATE));
		} else if (player.isMaging()) {
			player.setCombat(new MeleeCombat(player, this.getBarrelchestMkII().getNPC(), CombatType.MAGIC, AttackType.ACCURATE));
		} else if (player.isRanging()) {
			player.setCombat(new MeleeCombat(player, this.getBarrelchestMkII().getNPC(), CombatType.RANGE, AttackType.ACCURATE));
		}
		// Estate agent dialogue.
		this.setEstateAgent(new EstateAgent());
		this.getEstateAgent().setForceChat(new ForceChat("Good day!"));
		// Show zombie head dialogue (first one).
		this.setZombieStressLevel(ZombieStressLevel.NONE);
		switch (this.getZombieStressLevel()) {
			case NONE:
				break;
			case WET_WILLY:
				break;
			case NOSE_PINCH:
				break;
			case PIG_NOSE:
				break;
			case SHAKE_HEAD:
				break;
			case INSULT:
				break;
		}
		// Show the stress stuff and head forced chat.
		// Show zombie head dialogue more.
		// "You stuff the still protesting zombie head into your pack!"
	}

	/* (non-Javadoc)
	 * @see com.netty.model.player.quest.Quest#rewards()
	 */
	@Override
	public int[][] rewards() {
		return null;
	}

	/* (non-Javadoc)
	 * @see com.netty.model.player.quest.Quest#getQuestPoints()
	 */
	@Override
	public int getQuestPoints() {
		return 0;
	}

	/**
	 * 
	 * @param postiePete
	 * 			The id to set.
	 */
	public void setPostiePete(PostiePete postiePete) {
		this.postiePete = postiePete;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public PostiePete getPostiePete() {
		return this.postiePete;
	}

	/**
	 * 
	 * @param barrelchestMkII
	 * 			The id to set.
	 */
	public void setBarrelchestMkII(BarrelchestMkII barrelchestMkII) {
		this.barrelchestMkII = barrelchestMkII;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public BarrelchestMkII getBarrelchestMkII() {
		return this.barrelchestMkII;
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
	 * @param zombieStressLevel
	 * 			The id to set.
	 */
	public void setZombieStressLevel(ZombieStressLevel zombieStressLevel) {
		this.zombieStressLevel = zombieStressLevel;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public ZombieStressLevel getZombieStressLevel() {
		return this.zombieStressLevel;
	}
}