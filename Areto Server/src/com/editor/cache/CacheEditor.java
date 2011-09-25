package com.editor.cache;

import javax.swing.JFrame;

import com.editor.Editor;
import com.netty.annotations.AnnotationType;
import com.netty.annotations.Edit;

/**
 * An editor to edit the cache file
 * system within the client. This will
 * mainly be used for higher revisions
 * when we need to add things such as
 * new interfaces and whatnot.
 * 
 * @author Joshua Rodrigues
 * @since Sep 18, 2011 11:53:01 PM
 */
@Edit(getAnnotationType = AnnotationType.EDIT)
public class CacheEditor extends Editor {

	/**
	 * Constructs a new cache editor
	 * to edit the cache.
	 */
	public CacheEditor() {
		super(new JFrame("Interface Editor"));
	}
}