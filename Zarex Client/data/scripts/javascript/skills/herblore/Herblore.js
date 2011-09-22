Herblore.prototype = new Skill();

function Herblore() {

	var object = new Object();
	object.name = '';

	function setName(name) {
		this.name = name;
	}

	function getName() {
		return this.name;
	}

	var firstIngrediant = new Ingrediant()
	var secondIngrediant = new Ingrediant()
}