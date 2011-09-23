package com.netty.script.batch;

import java.io.File;

import com.netty.script.Script;
import com.netty.script.ScriptType;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 21, 2011 12:10:23 PM
 */
public class BatchScript extends Script {

	/**
	 * 
	 * @param file
	 * 			The id to set.
	 * @param scriptType
	 * 			The id to set.
	 */
	public BatchScript(File file, ScriptType scriptType) {
		super(file, scriptType);
	}
}