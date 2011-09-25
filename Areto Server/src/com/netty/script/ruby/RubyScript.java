package com.netty.script.ruby;

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
 * 
 * @author Joshua Rodrigues
 * @since Sep 21, 2011 12:05:53 PM
 */
public class RubyScript extends Script {

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
	private List<Script> rubyScriptList;

	/**
	 * 
	 */
	public RubyScript() {
		super(null, null);
		this.setScriptEngineManager(new ScriptEngineManager());
		this.setScriptEngine(this.getScriptEngineManager().getEngineByName("Ruby"));
		this.setRubyScriptList(new ArrayList<Script>());
	}

	/**
	 * 
	 * @param rubyScriptFile
	 * 			The id to set.
	 * @return
	 * 			The id to set.
	 */
	public Object getRubyExecution(String rubyScriptFile) {
		File file = new File(ScriptConstants.RUBY_PATH + rubyScriptFile);
		Script script = new Script(file, ScriptType.RUBY);
		this.getRubyScriptList().add(script);
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
	 * 			The id to set.
	 * @return
	 * 			The id to set.
	 */
	public Script getRubyName(String name) {
		if (name == null) {
			return null;
		}
		if (name.equals("")) {
			return null;
		}
		for (Script script : this.getRubyScriptList()) {
			if (name.equals(script.getFile().getName())) {
				return script;
			}
		}
		return null;
	}

	/**
	 * 
	 * @param functionName
	 * 			The id to set.
	 * @param arguments
	 * 			The id to set.
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
	 * 			The id to set.
	 */
	public void setScriptEngineManager(ScriptEngineManager scriptEngineManager) {
		this.scriptEngineManager = scriptEngineManager;
	}

	/**
	 * 
	 * @return scriptEngineManager
	 * 			The id to set.
	 */
	public ScriptEngineManager getScriptEngineManager() {
		return this.scriptEngineManager;
	}

	/**
	 * 
	 * @param scriptEngine
	 * 			The id to set.
	 */
	public void setScriptEngine(ScriptEngine scriptEngine) {
		this.scriptEngine = scriptEngine;
	}

	/**
	 * 
	 * @return scriptEngine
	 * 			The id to set.
	 */
	public ScriptEngine getScriptEngine() {
		return this.scriptEngine;
	}

	/**
	 * 
	 * @param rubyScriptList
	 * 			The id to set.
	 */
	public void setRubyScriptList(List<Script> rubyScriptList) {
		this.rubyScriptList = rubyScriptList;
	}

	/**
	 * 
	 * @return rubyScriptList
	 * 			The id to set.
	 */
	public List<Script> getRubyScriptList() {
		return this.rubyScriptList;
	}
}