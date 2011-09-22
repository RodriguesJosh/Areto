package com.netty.game.model.entity.menu.menuname.impl;

import com.netty.game.model.entity.menu.menuaction.MenuActionHandler;
import com.netty.game.model.entity.menu.menuname.MenuName;
import com.netty.game.model.entity.menu.menuname.MenuType;

public class GroundItemExamineMenuName extends MenuName {

	public GroundItemExamineMenuName() {
		super("Examine", MenuType.ITEM);
	}

	@Override
	public Class<?> getMenuAction() {
		String packageName = "com.netty.game.model.entity.menu.menuaction.impl.";
		ClassLoader classLoader = ClassLoader.getSystemClassLoader();
		Class<?> groundItemExamineClass = null;
		try {
			groundItemExamineClass = classLoader.loadClass(packageName + "GroundItemExamineMenuAction");
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}
		if (groundItemExamineClass == null) {
			return null;
		}
		MenuActionHandler menuActionHandler = null;
		try {
			menuActionHandler = (MenuActionHandler) groundItemExamineClass.newInstance();
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