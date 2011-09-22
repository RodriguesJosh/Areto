Crafting.prototype = new Skill();

function Crafting() {

	var object = new Object();
	object.name = '';

	function setName(name) {
		this.name = name;
	}

	function getName() {
		return this.name;
	}

	var gem = new Gem()
}