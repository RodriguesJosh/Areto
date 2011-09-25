package com.netty.script;

import java.io.File;

/**
 * 
 * @author josh
 * @version 0.1
 * @since 0.1
 */
public class Script {

	/**
	 * 
	 */
	private File file;

	/**
	 * 
	 */
	private ScriptType scriptType;

	/**
	 * 
	 * @param file
	 * 			The id to set.
	 * @param scriptType
	 * 			The id to set.
	 */
	public Script(File file, ScriptType scriptType) {
		this.setFile(file);
		this.setScriptType(scriptType);
	}

	/**
	 * 
	 * @param file
	 * 			The id to set.
	 */
	public void setFile(File file) {
		this.file = file;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public File getFile() {
		return this.file;
	}

	/**
	 * 
	 * @param scriptType
	 * 			The id to set.
	 */
	public void setScriptType(ScriptType scriptType) {
		this.scriptType = scriptType;
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public ScriptType getScriptType() {
		return this.scriptType;
	}
}