package com.netty.game.model.entity.menu.menuname.impl;

import com.netty.game.model.entity.menu.menuaction.MenuActionHandler;
import com.netty.game.model.entity.menu.menuname.MenuName;
import com.netty.game.model.entity.menu.menuname.MenuType;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 25, 2011 2:38:29 PM
 */
public class NPCExamineMenuName extends MenuName {

	/**
	 * 
	 */
	public NPCExamineMenuName() {
		super("Examine", MenuType.NPC);
	}

	/* (non-Javadoc)
	 * @see com.netty.game.model.entity.menu.menuname.MenuName#getMenuAction()
	 */
	@Override
	public Class<?> getMenuAction() {
		String packageName = "com.netty.game.model.entity.menu.menuaction.impl.";
		ClassLoader classLoader = ClassLoader.getSystemClassLoader();
		Class<?> npcExamineClass = null;
		try {
			npcExamineClass = classLoader.loadClass(packageName + "NPCExamineMenuAction");
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}
		if (npcExamineClass == null) {
			return null;
		}
		MenuActionHandler menuActionHandler = null;
		try {
			menuActionHandler = (MenuActionHandler) npcExamineClass.newInstance();
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