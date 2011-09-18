package com.netty.script.javascript;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import com.netty.script.Script;
import com.netty.script.ScriptConstants;
import com.netty.script.ScriptType;

/**
 * 
 * @author josh
 * @since 0.1
 */
public class JavaScript {

	/**
	 * 
	 */
	private ScriptEngineManager scriptEngineManager;

	/**
	 * 
	 */
	private ScriptEngine scriptEngine;

	/**
	 * 
	 */
	private List<Script> javaScriptList;

	/**
	 * 
	 */
	public JavaScript() {
		this.setScriptEngineManager(new ScriptEngineManager());
		this.setScriptEngine(this.getScriptEngineManager().getEngineByName("JavaScript"));
		this.setJavaScriptList(new ArrayList<Script>());
	}

	/**
	 * 
	 * @param javaScriptFile
	 * @return
	 */
	public Object getJSExecution(String javaScriptFile) {
		File file = new File(ScriptConstants.JAVA_SCRIPT_PATH + javaScriptFile);
		Script script = new Script(file, ScriptType.JAVA_SCRIPT);
		this.getJavaScriptList().add(script);
		if (!file.exists()) {
			return null;
		}
		if (!file.isDirectory()) {
			return null;
		}
		try {
			return this.getScriptEngine().eval(new InputStreamReader(new FileInputStream(script.getFile())));
		} catch (ScriptException se) {
			se.printStackTrace();
		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		}
		return null;
	}

	/**
	 * 
	 * @param name
	 * @return
	 */
	public Script getJSName(String name) {
		if (name == null) {
			return null;
		}
		if (name.equals("")) {
			return null;
		}
		for (Script script : this.getJavaScriptList()) {
			if (name.equals(script.getFile().getName())) {
				return script;
			}
		}
		return null;
	}

	/**
	 * 
	 * @param functionName
	 * @param arguments
	 */
	public void invokeFunction(String functionName, Object... arguments) {
		Invocable invocable = (Invocable) this.getScriptEngine();
		try {
			invocable.invokeFunction(functionName, arguments);
		} catch (NoSuchMethodException nsme) {
			nsme.printStackTrace();
		} catch (ScriptException se) {
			se.printStackTrace();
		}
	}

	/**
	 * 
	 * @param scriptEngineManager
	 */
	public void setScriptEngineManager(ScriptEngineManager scriptEngineManager) {
		this.scriptEngineManager = scriptEngineManager;
	}

	/**
	 * 
	 * @return scriptEngineManager
	 */
	public ScriptEngineManager getScriptEngineManager() {
		return this.scriptEngineManager;
	}

	/**
	 * 
	 * @param scriptEngine
	 */
	public void setScriptEngine(ScriptEngine scriptEngine) {
		this.scriptEngine = scriptEngine;
	}

	/**
	 * 
	 * @return scriptEngine
	 */
	public ScriptEngine getScriptEngine() {
		return this.scriptEngine;
	}

	/**
	 * 
	 * @param javaScriptList
	 */
	public void setJavaScriptList(List<Script> javaScriptList) {
		this.javaScriptList = javaScriptList;
	}

	/**
	 * 
	 * @return javaScriptList
	 */
	public List<Script> getJavaScriptList() {
		return this.javaScriptList;
	}
}