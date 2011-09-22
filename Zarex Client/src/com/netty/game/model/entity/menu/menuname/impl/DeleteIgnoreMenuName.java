package com.netty.game.model.entity.menu.menuname.impl;

import com.netty.game.model.entity.menu.menuaction.MenuActionHandler;
import com.netty.game.model.entity.menu.menuname.MenuName;
import com.netty.game.model.entity.menu.menuname.MenuType;

public class DeleteIgnoreMenuName extends MenuName {

	public DeleteIgnoreMenuName() {
		super("Delete", MenuType.PLAYER);
	}

	@Override
	public Class<?> getMenuAction() {
		String packageName = "com.netty.game.model.entity.menu.menuaction.impl.";
		ClassLoader classLoader = ClassLoader.getSystemClassLoader();
		Class<?> deleteIgnoreClass = null;
		try {
			deleteIgnoreClass = classLoader.loadClass(packageName + "DeleteIgnoreMenuAction");
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}
		if (deleteIgnoreClass == null) {
			return null;
		}
		MenuActionHandler menuActionHandler = null;
		try {
			menuActionHandler = (MenuActionHandler) deleteIgnoreClass.newInstance();
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