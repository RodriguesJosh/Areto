package com.netty.script.lisp;

import java.io.File;

import com.netty.script.Script;
import com.netty.script.ScriptType;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 21, 2011 12:08:20 PM
 */
public class LispScript extends Script {

	/**
	 * 
	 * @param file
	 * 			The id to set.
	 * @param scriptType
	 * 			The id to set.
	 */
	public LispScript(File file, ScriptType scriptType) {
		super(file, scriptType);
	}
}