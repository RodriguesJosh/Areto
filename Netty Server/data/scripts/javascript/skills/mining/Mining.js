Mining.prototype = new Skill();

function Mining() {

	var object = new Object();
	object.name = '';

	function setName(name) {
		this.name = name;
	}

	function getName() {
		return this.name;
	}

	var ore = new Ore();
	var pickaxe = new Pickaxe();
}