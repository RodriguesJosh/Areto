package com.netty.annotations;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * A class to manage all the annotations created.
 * Each annotation will have a specific task to
 * do.
 * 
 * @author Joshua Rodrigues
 * @since Sep 19, 2011 1:22:21 PM
 */
@Finished(getAnnotationType = AnnotationType.FINISHED)
public class AnnotationManager {

	/**
	 * The main method to execute upon startup
	 * of this program.
	 * 
	 * @param args
	 * 			The program's arguments.
	 */
	public static void main(String[] args) {
		File directoryFile = new File("../Netty Server/src/com/");
		if (!directoryFile.exists()) {
			try {
				throw new FileNotFoundException("Directory does not exist: " + directoryFile);
			} catch (FileNotFoundException fnfe) {
				fnfe.printStackTrace();
			}
		}
		if (!directoryFile.isDirectory()) {
			throw new IllegalArgumentException("Is not a directory: " + directoryFile);
		}
		if (!directoryFile.canRead()) {
			try {
				throw new IllegalAccessException("Directory cannot be read: " + directoryFile);
			} catch (IllegalAccessException iae) {
				iae.printStackTrace();
			}
		}
		List<File> fileList = AnnotationManager.getFileListing(directoryFile);
		Collections.sort(fileList);
		if (fileList == null) {
			return;
		}
		for (File file : fileList) {
			Class<?> classes = file.getClass();
			Annotation[] annotations = classes.getAnnotations();
			for (Annotation annotation : annotations) {
				if (annotation.annotationType().equals("Finished")) {
					classes = null;
					/**
					 * Make it so that you store the original files into a Map or a List
					 * and simply check if it has been changed.
					 */
				}
			}
		}
	}

	/**
	 * Gets all the files when we do a recursive check
	 * for files that end with .java.
	 * 
	 * @param startingFile
	 * 			The file to start with to recursive
	 * 			check.
	 * @return resultList
	 * 			Returns a list filled with results.
	 */
	public static List<File> getFileListing(File startingFile) {
		List<File> resultList = new ArrayList<File>();
		File[] files = startingFile.listFiles();
		List<File> fileDirectoryList = Arrays.asList(files);
		for (File file : fileDirectoryList) {
			if (file.getName().endsWith(".java")) {
				resultList.add(file);
			}
			if (!file.isFile()) {
				List<File> deeperFileList = AnnotationManager.getFileListing(file);
				resultList.addAll(deeperFileList);
			}
		}
		return resultList;
	}
}