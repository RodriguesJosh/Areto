package com.editor.interfaces;

import javax.swing.JFrame;

import com.editor.Editor;
import com.netty.annotations.AnnotationType;
import com.netty.annotations.Edit;

/**
 * An interface editor to edit interfaces
 * within the cache of the client.
 * 
 * @author Joshua Rodrigues
 * @since Sep 18, 2011 11:53:22 PM
 */
@Edit(getAnnotationType = AnnotationType.EDIT)
public class InterfaceEditor extends Editor {

	/**
	 * Constructs a new interface editor
	 * to edit interfaces.
	 */
	public InterfaceEditor() {
		super(new JFrame("Interface Editor"));
	}
}