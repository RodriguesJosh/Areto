Runecrafting.prototype = new Skill();

function Runecrafting() {

	var object = new Object();
	object.name = '';

	function setName(name) {
		this.name = name;
	}

	function getName() {
		return this.name;
	}

	var altar = new Altar();
	var rune = new Rune();
}