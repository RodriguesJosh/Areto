Firemaking.prototype = new Skill();

function Firemaking() {

	var object = new Object();
	object.name = '';

	function setName(name) {
		this.name = name;
	}

	function getName() {
		return this.name;
	}

	var logs = new Log();
}
