package com.netty.game.model.entity.menu.menuname.impl;

import com.netty.game.model.entity.menu.menuaction.MenuActionHandler;
import com.netty.game.model.entity.menu.menuname.MenuName;
import com.netty.game.model.entity.menu.menuname.MenuType;

public class WalkMenuName extends MenuName {

	public WalkMenuName() {
		super("Walk here", MenuType.NPC, MenuType.PLAYER, MenuType.OBJECT, MenuType.OTHER, MenuType.ITEM);
	}

	@Override
	public Class<?> getMenuAction() {
		String packageName = "com.netty.game.model.entity.menu.menuaction.impl.";
		ClassLoader classLoader = ClassLoader.getSystemClassLoader();
		Class<?> walkClass = null;
		try {
			walkClass = classLoader.loadClass(packageName + "WalkMenuAction");
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}
		if (walkClass == null) {
			return null;
		}
		MenuActionHandler menuActionHandler = null;
		try {
			menuActionHandler = (MenuActionHandler) walkClass.newInstance();
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
