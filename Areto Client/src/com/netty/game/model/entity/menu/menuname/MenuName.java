package com.netty.game.model.entity.menu.menuname;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 25, 2011 2:37:11 PM
 */
public abstract class MenuName {

	/**
	 * 
	 */
	private String name;

	/**
	 * 
	 */
	private MenuType[] menuTypes;

	/**
	 * 
	 * @param name
	 * 			The id to set.
	 * @param menuTypes
	 * 			The id to set.
	 */
	public MenuName(String name, MenuType... menuTypes) {
		this.setName(name);
		this.setMenuTypes(menuTypes);
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public abstract Class<?> getMenuAction();

	/**
	 * 
	 * @param name
	 * 			The id to set.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * 
	 * @param menuTypes
	 * 			The id to set.
	 */
	public void setMenuTypes(MenuType... menuTypes) {
		this.menuTypes = menuTypes;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public MenuType[] getMenuTypes() {
		return this.menuTypes;
	}
}