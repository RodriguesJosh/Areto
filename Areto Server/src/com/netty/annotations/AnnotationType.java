package com.netty.annotations;

import com.netty.annotations.task.Task;
import com.netty.annotations.task.impl.EditTask;
import com.netty.annotations.task.impl.FinishedTask;

/**
 * The type of annotations along with a task
 * to fit their repsective goals.
 * 
 * @author Joshua Rodrigues
 * @since Sep 19, 2011 1:32:06 PM
 */
public enum AnnotationType {

	/**
	 * The edit enum to represent an editable
	 * product.
	 */
	EDIT(new EditTask()),

	/**
	 * The finished enum to represent a finished
	 * product.
	 */
	FINISHED(new FinishedTask());

	/**
	 * The task to use on the type of annotation.
	 */
	private Task task;

	/**
	 * Constructs a new type of annotation
	 * along with a task to go along with.
	 * 
	 * @param task
	 * 			The task to set.
	 */
	private AnnotationType(Task task) {
		this.setTask(task);
	}

	/**
	 * Sets the task for the respective annotation
	 * type.
	 * 
	 * @param task
	 * 			The task to set.
	 */
	public void setTask(Task task) {
		this.task = task;
	}

	/**
	 * Gets the task for the respective annotation
	 * type.
	 * 
	 * @return task
	 * 			Returns the task for the annotation
	 * 			type.
	 */
	public Task getTask() {
		return this.task;
	}
}