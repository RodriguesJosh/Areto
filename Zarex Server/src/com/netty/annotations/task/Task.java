package com.netty.annotations.task;

import com.netty.annotations.AnnotationType;
import com.netty.annotations.Finished;

/**
 * Represents a task for each annotation.
 * 
 * @author Joshua Rodrigues
 * @since Sep 19, 2011 1:24:34 PM
 */
@Finished(getAnnotationType = AnnotationType.FINISHED)
public interface Task {

	/**
	 * Execute a task for the given annotation.
	 * 
	 * @return
	 * 		A specific task to execute for an
	 * 		annotation.
	 */
	public Object executeTask();
}