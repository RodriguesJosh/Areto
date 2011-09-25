package com.netty.game.model.entity.menu.menuname.impl;

import com.netty.game.model.entity.menu.menuaction.MenuActionHandler;
import com.netty.game.model.entity.menu.menuname.MenuName;
import com.netty.game.model.entity.menu.menuname.MenuType;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 25, 2011 2:40:44 PM
 */
public class DeleteFriendMenuName extends MenuName {

	/**
	 * 
	 */
	public DeleteFriendMenuName() {
		super("Delete", MenuType.PLAYER);
	}

	/* (non-Javadoc)
	 * @see com.netty.game.model.entity.menu.menuname.MenuName#getMenuAction()
	 */
	@Override
	public Class<?> getMenuAction() {
		String packageName = "com.netty.game.model.entity.menu.menuaction.impl.";
		ClassLoader classLoader = ClassLoader.getSystemClassLoader();
		Class<?> deleteFriendClass = null;
		try {
			deleteFriendClass = classLoader.loadClass(packageName + "DeleteFriendMenuAction");
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}
		if (deleteFriendClass == null) {
			return null;
		}
		MenuActionHandler menuActionHandler = null;
		try {
			menuActionHandler = (MenuActionHandler) deleteFriendClass.newInstance();
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