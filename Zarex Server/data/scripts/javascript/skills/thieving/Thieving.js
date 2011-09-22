Thieving.prototype = new Skill();

function Thieving() {

	var object = new Object();
	object.name = '';

	function setName(name) {
		this.name = name;
	}

	function getName() {
		return this.name;
	}

	var stall = new Stall();
	var pickpocket = new Pickpocket();
}