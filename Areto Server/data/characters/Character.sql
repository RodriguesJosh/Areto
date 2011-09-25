CREATE TABLE `character` (
	`id` int(10) unsigned NOT NULL auto_increment,
	`name` varchar(15) NOT NULL,
	`pass` varchar(140) NOT NULL,
	`x` int(10) unsigned NOT NULL default '0',
	`y` int(10) unsigned NOT NULL default '0',
	`z` int(10) unsigned NOT NULL default '0',
	`rights` int(10) unsigned NOT NULL default '0',
	`gender` int(10) unsigned NOT NULL default '0',
	PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;