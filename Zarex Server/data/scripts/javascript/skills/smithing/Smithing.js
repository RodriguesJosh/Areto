Smithing.prototype = new Skill();

function Smithing() {

	var object = new Object();
	object.name = '';

	function setName(name) {
		this.name = name;
	}

	function getName() {
		return this.name;
	}

	var firstOre = new Ore();
	var secondOre = new Ore();
}