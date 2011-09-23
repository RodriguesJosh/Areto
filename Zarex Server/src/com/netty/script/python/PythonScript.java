package com.netty.script.python;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import org.python.core.Py;
import org.python.core.PyException;
import org.python.core.PyFunction;
import org.python.core.PyObject;
import org.python.util.PythonInterpreter;

import com.netty.script.Script;
import com.netty.script.ScriptConstants;
import com.netty.script.ScriptType;

/**
 * 
 * 
 * @author Joshua Rodrigues
 * @since Sep 21, 2011 12:06:44 PM
 */
public class PythonScript extends Script {

	/**
	 * 
	 */
	private PythonInterpreter pythonInterpreter;

	/**
	 * 
	 */
	private List<Script> pythonScriptList;

	/**
	 * 
	 */
	public PythonScript() {
		super(null, null);
		this.setPythonInterpreter(new PythonInterpreter());
		this.setPythonScriptList(new ArrayList<Script>());
	}

	/**
	 * 
	 * @param functionName
	 * 			The id to set.
	 * @param arguments
	 * 			The id to set.
	 * @return
	 * 			The id to set.
	 */
	public PyObject getPythonExecution(String functionName, Object... arguments) {
		try {
			PyObject pythonObject = this.getPythonInterpreter().get(functionName);
			if (pythonObject == null) {
				return null;
			}
			if (!(pythonObject instanceof PyFunction)) {
				return null;
			}
			PyFunction pythonFunction = (PyFunction) pythonObject;
			PyObject[] objects = new PyObject[arguments.length];
			for (int i = 0; i < arguments.length; i++) {
				objects[i] = Py.java2py(arguments[i]);
			}
			pythonFunction.__call__(objects);
		} catch (PyException pe) {
			pe.printStackTrace();
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
	public Script getPythonName(String name) {
		if (name == null) {
			return null;
		}
		if (name.equals("")) {
			return null;
		}
		for (Script script : this.getPythonScriptList()) {
			if (name.equals(script.getFile().getName())) {
				return script;
			}
		}
		return null;
	}

	/**
	 * 
	 */
	public void load() {
		this.getPythonInterpreter().cleanup();
		File pythonScript = new File(ScriptConstants.SCRIPTS_PATH);
		if (!pythonScript.isDirectory()) {
			return;
		}
		File[] pythonScriptFiles = pythonScript.listFiles();
		for (File scriptFile : pythonScriptFiles) {
			if (!scriptFile.isFile()) {
				return;
			}
			if (scriptFile.getName() == null) {
				return;
			}
			if (!scriptFile.getName().endsWith(".py")) {
				return;
			}
			Script script = new Script(scriptFile, ScriptType.PYTHON);
			this.getPythonScriptList().add(script);
			// long start = System.nanoTime();
			try {
				this.getPythonInterpreter().execfile(new FileInputStream(script.getFile()));
			} catch (FileNotFoundException fnfe) {
				fnfe.printStackTrace();
			}
			// long elapsed = System.nanoTime() - start;
			// logger.info("Loaded script: " + scriptFile.getName() + " in " + elapsed / 1000000D + " milliseconds");
			// parsed++;
		}
		// logger.info("Parsed " + parsed + " scripts.");
	}

	/**
	 * 
	 * @param pythonInterpreter
	 * 			The id to set.
	 */
	public void setPythonInterpreter(PythonInterpreter pythonInterpreter) {
		this.pythonInterpreter = pythonInterpreter;
	}

	/**
	 * 
	 * @return pythonInterpreter
	 * 			The id to set.
	 */
	public PythonInterpreter getPythonInterpreter() {
		return this.pythonInterpreter;
	}

	/**
	 * 
	 * @param pythonScriptList
	 * 			The id to set.
	 */
	public void setPythonScriptList(List<Script> pythonScriptList) {
		this.pythonScriptList = pythonScriptList;
	}

	/**
	 * 
	 * @return pythonScriptList
	 * 			The id to set.
	 */
	public List<Script> getPythonScriptList() {
		return this.pythonScriptList;
	}
}