package com.netty.game.model.entity.menu.menuname.impl;

import com.netty.game.model.entity.menu.menuaction.MenuActionHandler;
import com.netty.game.model.entity.menu.menuname.MenuName;
import com.netty.game.model.entity.menu.menuname.MenuType;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 25, 2011 2:38:24 PM
 */
public class ObjectExamineMenuName extends MenuName {

	/**
	 * 
	 */
	public ObjectExamineMenuName() {
		super("Examine", MenuType.OBJECT);
	}

	/* (non-Javadoc)
	 * @see com.netty.game.model.entity.menu.menuname.MenuName#getMenuAction()
	 */
	@Override
	public Class<?> getMenuAction() {
		String packageName = "com.netty.game.model.entity.menu.menuaction.impl.";
		ClassLoader classLoader = ClassLoader.getSystemClassLoader();
		Class<?> objectExamineClass = null;
		try {
			objectExamineClass = classLoader.loadClass(packageName + "ObjectExamineMenuAction");
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}
		if (objectExamineClass == null) {
			return null;
		}
		MenuActionHandler menuActionHandler = null;
		try {
			menuActionHandler = (MenuActionHandler) objectExamineClass.newInstance();
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