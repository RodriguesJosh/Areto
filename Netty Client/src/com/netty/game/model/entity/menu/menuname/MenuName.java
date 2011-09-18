package com.netty.game.model.entity.menu.menuname;

public abstract class MenuName {

	private String name;
	private MenuType[] menuTypes;

	public MenuName(String name, MenuType... menuTypes) {
		this.setName(name);
		this.setMenuTypes(menuTypes);
	}

	public abstract Class<?> getMenuAction();

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void setMenuTypes(MenuType... menuTypes) {
		this.menuTypes = menuTypes;
	}

	public MenuType[] getMenuTypes() {
		return this.menuTypes;
	}
}
