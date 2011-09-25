Farming.prototype = new Skill();

function Farming() {

	var object = new Object();
	object.name = '';

	function setName(name) {
		this.name = name;
	}

	function getName() {
		return this.name;
	}

	var flower = new Flower()
	var seed = new Seed()
}