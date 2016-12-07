/**
 * Copyright 2016 Netflix, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
/**
 * 
 */
package com.netflix.conductor.contribs.tasks;

import com.netflix.conductor.common.metadata.tasks.Task;
import com.netflix.conductor.common.metadata.tasks.Task.Status;
import com.netflix.conductor.common.run.Workflow;
import com.netflix.conductor.core.execution.WorkflowExecutor;
import com.netflix.conductor.core.execution.tasks.WorkflowSystemTask;

/**
 * @author Viren
 *
 */
public class Wait extends WorkflowSystemTask {

	public static final String NAME = "WAIT";
	
	public Wait() {
		super(NAME);
	}
	
	@Override
	public void start(Workflow workflow, Task task, WorkflowExecutor executor) throws Exception {
		task.setStatus(Status.IN_PROGRESS);
	}

	@Override
	public boolean execute(Workflow workflow, Task task, WorkflowExecutor executor) throws Exception {
		return false;
	}
	
	@Override
	public void cancel(Workflow workflow, Task task, WorkflowExecutor executor) throws Exception {
		task.setStatus(Status.CANCELED);
	}
}