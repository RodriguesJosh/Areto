package com.netty.game.model.entity.menu;

import java.util.ArrayList;
import java.util.List;

import com.netty.game.model.entity.menu.menuname.MenuName;

public abstract class Menu {

	private List<MenuName> menuNameList;

	public Menu() {
		this.setMenuNameList(new ArrayList<MenuName>());
		// this.getMenuNameList().add(new WalkMenuName()); // Index of 0 - top but last - do not change.
		// this.getMenuNameList().add(new CancelMenuName()); // Index of 1 - bottom and last - do not change.
	}

	// public abstract

	public void setMenuNameList(List<MenuName> menuNameList) {
		this.menuNameList = menuNameList;
	}

	public List<MenuName> getMenuNameList() {
		return this.menuNameList;
	}
}
