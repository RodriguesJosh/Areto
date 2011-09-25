package com.editor;

import java.awt.Dimension;

import javax.swing.JFrame;

import com.netty.annotations.AnnotationType;
import com.netty.annotations.Edit;

/**
 * An Editor that will be the main
 * source for any editor you wish
 * to make.
 * 
 * @author josh
 * @since Sep 18, 2011 11:50:08 PM
 */
@Edit(getAnnotationType = AnnotationType.EDIT)
public abstract class Editor {

	/**
	 * Constructs a new editor to use/make.
	 * The editor will be used so things in
	 * the cache can be edited (items, maps,
	 * images, etc).
	 * 
	 * @param jFrame
	 * 			The {@link JFrame} for the editor we wish to
	 * 			use.
	 */
	public Editor(JFrame jFrame) {
		jFrame.setPreferredSize(new Dimension(500, 500));
		jFrame.setVisible(true);
	}
}