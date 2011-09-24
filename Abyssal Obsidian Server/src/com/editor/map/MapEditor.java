package com.editor.map;

import javax.swing.JFrame;

import com.editor.Editor;
import com.netty.annotations.AnnotationType;
import com.netty.annotations.Edit;

/**
 * A map editor to edit the map files
 * within the cache for the client.
 * 
 * @author Joshua Rodrigues
 * @since Sep 18, 2011 11:53:32 PM
 */
@Edit(getAnnotationType = AnnotationType.EDIT)
public class MapEditor extends Editor {

	/**
	 * Constructs a new map editor to edit
	 * the map files.
	 */
	public MapEditor() {
		super(new JFrame("Interface Editor"));
	}
}