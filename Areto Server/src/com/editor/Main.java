package com.editor;

import com.editor.cache.CacheEditor;
import com.editor.interfaces.InterfaceEditor;
import com.editor.map.MapEditor;
import com.netty.annotations.AnnotationType;
import com.netty.annotations.Edit;

/**
 * The main class to startup the {@link Editor}
 * classes that will edit the cache, the maps
 * as well as interfaces in the client.
 * 
 * @author Joshua Rodrigues
 * @since Sep 18, 2011 11:52:40 PM
 */
@Edit(getAnnotationType = AnnotationType.EDIT)
public class Main {

	/**
	 * The main method to execute upon startup
	 * of this program.
	 * 
	 * @param args
	 * 			The program's arguments.
	 */
	public static void main(String[] args) {
		new CacheEditor();
		new MapEditor();
		new InterfaceEditor();
	}
}