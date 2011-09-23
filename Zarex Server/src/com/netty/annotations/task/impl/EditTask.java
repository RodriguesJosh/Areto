package com.netty.annotations.task.impl;

import com.netty.annotations.AnnotationType;
import com.netty.annotations.Edit;
import com.netty.annotations.task.Task;

/**
 * A task for the edit annotation.
 * 
 * @author Joshua Rodrigues
 * @since Sep 19, 2011 1:23:50 PM
 */
@Edit(getAnnotationType = AnnotationType.EDIT)
public class EditTask implements Task {

	/* (non-Javadoc)
	 * @see com.netty.annotations.task.Task#executeTask()
	 */
	@Override
	public Object executeTask() {
		return null;
	}
}