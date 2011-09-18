Smelting.prototype = new Skill();

function Smelting() {

	var object = new Object();
	object.name = '';

	function setName(name) {
		this.name = name;
	}

	function getName() {
		return this.name;
	}

	var bar = new Bar();
	var hammerItem = new Itme();
}