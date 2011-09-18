Cooking.prototype = new Skill();

function Cooking() {

	var object = new Object();
	object.name = '';

	function setName(name) {
		this.name = name;
	}

	function getName() {
		return this.name;
	}

	var fish = new Fish()
}