package com.netty.game.model.entity.menu.menuname.impl;

import com.netty.game.model.entity.menu.menuaction.MenuActionHandler;
import com.netty.game.model.entity.menu.menuname.MenuName;
import com.netty.game.model.entity.menu.menuname.MenuType;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 25, 2011 2:40:24 PM
 */
public class InventoryItemExamineMenuName extends MenuName {

	/**
	 * 
	 */
	public InventoryItemExamineMenuName() {
		super("Examine", MenuType.ITEM);
	}

	/* (non-Javadoc)
	 * @see com.netty.game.model.entity.menu.menuname.MenuName#getMenuAction()
	 */
	@Override
	public Class<?> getMenuAction() {
		String packageName = "com.netty.game.model.entity.menu.menuaction.impl.";
		ClassLoader classLoader = ClassLoader.getSystemClassLoader();
		Class<?> inventoryItemExamineClass = null;
		try {
			inventoryItemExamineClass = classLoader.loadClass(packageName + "InventoryItemExamineMenuAction");
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}
		if (inventoryItemExamineClass == null) {
			return null;
		}
		MenuActionHandler menuActionHandler = null;
		try {
			menuActionHandler = (MenuActionHandler) inventoryItemExamineClass.newInstance();
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