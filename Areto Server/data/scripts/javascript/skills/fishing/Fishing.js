Fishing.prototype = new Skill();

function Fishing() {

	var object = new Object();
	object.name = '';

	function setName(name) {
		this.name = name;
	}

	function getName() {
		return this.name;
	}
	
	var fish = new Fish()
	var tools = new Tools()
}