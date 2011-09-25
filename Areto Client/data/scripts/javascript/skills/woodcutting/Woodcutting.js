Woodcutting.prototype = new Skill();

function Woodcutting() {

	var object = new Object();
	object.name = '';

	function setName(name) {
		this.name = name;
	}

	function getName() {
		return this.name;
	}

	var tree = new Tree();
	var hatchet = new Hatchet();
}