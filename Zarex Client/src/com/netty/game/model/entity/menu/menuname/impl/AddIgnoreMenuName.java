package com.netty.game.model.entity.menu.menuname.impl;

import com.netty.game.model.entity.menu.menuaction.MenuActionHandler;
import com.netty.game.model.entity.menu.menuname.MenuName;
import com.netty.game.model.entity.menu.menuname.MenuType;

public class AddIgnoreMenuName extends MenuName {

	public AddIgnoreMenuName() {
		super("Add", MenuType.PLAYER);
	}

	@Override
	public Class<?> getMenuAction() {
		String packageName = "com.netty.game.model.entity.menu.menuaction.impl.";
		ClassLoader classLoader = ClassLoader.getSystemClassLoader();
		Class<?> addIgnoreClass = null;
		try {
			addIgnoreClass = classLoader.loadClass(packageName + "AddIgnoreMenuAction");
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}
		if (addIgnoreClass == null) {
			return null;
		}
		MenuActionHandler menuActionHandler = null;
		try {
			menuActionHandler = (MenuActionHandler) addIgnoreClass.newInstance();
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