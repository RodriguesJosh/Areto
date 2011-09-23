package com.netty.model.player.tab;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 22, 2011 12:04:12 AM
 */
public class Notes {

	/**
	 * 
	 */
	private String note;

	/**
	 * 
	 */
	private String[] input;

	/**
	 * 
	 */
	private String[] filter;

	/**
	 * 
	 * @param note
	 * 			The id to set.
	 */
	public Notes(String note) {
		this.setNote(note);
		this.setInput(new String[] {
				"All your base are belong to us", "orly", "murder", "redurm", "Andrew", "Paul", "I am your father",
				"I'll be back", "Finish the fight", "There is no spoon", "You fight like a dairy farmer", "Bangin'",
				"Humperdinck", "Milton Waddams", "R.I.P. Runescape", "Penso, logo existo", "Le temps passe", "Sevga"
		});
		this.setFilter(new String[] {
				"orly?", "yarly", "All rest and no play makes Guthix a dull boy.", "Cabbage.",
				"Rargh, I'm a lava monster!", "Nooooooooooooooooooooooooo!", "Come with me if you want to live.",
				"They must love the smell of hero.",
				"Then you will see, it is not the spoon that bends, it is only yourself.",
				"How appropriate. You fight like a cow.", "donk", "Have fun storming the castle!",
				"The ratio of people to cake is too big.", "Wanna bet?", "Borboletas salpicadas de goiabada...",
				"L'�uf dur.", "Marmaros had a close encounter with a prayer-eating behemoth."
		});
		for (int i = 0; i < this.getInput().length; i++) {
			if (note == this.getInput()[i]) {
				// note = this.getFilter()[i];
			}
		}
	}

	/**
	 * 
	 * @param note
	 * 			The id to set.
	 */
	public void setNote(String note) {
		this.note = note;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public String getNote() {
		return this.note;
	}

	/**
	 * 
	 * @param input
	 * 			The id to set.
	 */
	public void setInput(String[] input) {
		this.input = input;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public String[] getInput() {
		return this.input;
	}

	/**
	 * 
	 * @param filter
	 * 			The id to set.
	 */
	public void setFilter(String[] filter) {
		this.filter = filter;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public String[] getFilter() {
		return this.filter;
	}
}