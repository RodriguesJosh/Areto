package com.netty.game.model.entity.menu.menuname.impl;

import com.netty.game.model.entity.menu.menuaction.MenuActionHandler;
import com.netty.game.model.entity.menu.menuname.MenuName;
import com.netty.game.model.entity.menu.menuname.MenuType;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 25, 2011 2:37:59 PM
 */
public class AddFriendMenuName extends MenuName {

	/**
	 * 
	 */
	public AddFriendMenuName() {
		super("Add", MenuType.PLAYER);
	}

	/* (non-Javadoc)
	 * @see com.netty.game.model.entity.menu.menuname.MenuName#getMenuAction()
	 */
	@Override
	public Class<?> getMenuAction() {
		String packageName = "com.netty.game.model.entity.menu.menuaction.impl.";
		ClassLoader classLoader = ClassLoader.getSystemClassLoader();
		Class<?> addFriendClass = null;
		try {
			addFriendClass = classLoader.loadClass(packageName + "AddFriendMenuAction");
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}
		if (addFriendClass == null) {
			return null;
		}
		MenuActionHandler menuActionHandler = null;
		try {
			menuActionHandler = (MenuActionHandler) addFriendClass.newInstance();
		} catch (InstantiationException ie) {
			ie.printStackTrace();
		} catch (IllegalAccessException iae) {
			iae.printStackTrace();
		}
		if (menuActionHandler == null) {
			return null;
		}
		return menuActionHandler.getClass();
	}
}