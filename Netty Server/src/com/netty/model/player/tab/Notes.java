package com.netty.model.player.tab;

public class Notes {

	private String note;
	private String[] input;
	private String[] filter;

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
				"L'œuf dur.", "Marmaros had a close encounter with a prayer-eating behemoth."
		});
		for (int i = 0; i < input.length; i++) {
			if (note == input[i]) {
				note = filter[i];
			}
		}
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getNote() {
		return this.note;
	}

	public void setInput(String[] input) {
		this.input = input;
	}

	public String[] getInput() {
		return this.input;
	}

	public void setFilter(String[] filter) {
		this.filter = filter;
	}

	public String[] getFilter() {
		return this.filter;
	}
}