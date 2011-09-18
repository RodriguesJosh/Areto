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
	 * @param scriptType
	 */
	public Script(File file, ScriptType scriptType) {
		this.setFile(file);
		this.setScriptType(scriptType);
	}

	/**
	 * 
	 * @param file
	 */
	public void setFile(File file) {
		this.file = file;
	}

	/**
	 * 
	 * @return
	 */
	public File getFile() {
		return this.file;
	}

	/**
	 * 
	 * @param scriptType
	 */
	public void setScriptType(ScriptType scriptType) {
		this.scriptType = scriptType;
	}

	/**
	 * 
	 * @return
	 */
	public ScriptType getScriptType() {
		return this.scriptType;
	}
}