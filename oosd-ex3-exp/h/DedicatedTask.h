/*
 * DedicatedTask.h
 *
 *  Created on: May 28, 2010
 *      Author: Avi
 */

#ifndef DEDICATEDTASK_H_
#define DEDICATEDTASK_H_

class TasksVisitor;

class DedicatedTask : public Task{

public:

	DedicatedTask();

	virtual ~DedicatedTask();

	void accept(TasksVisitor* v);
};

#endif /* DEDICATEDTASK_H_ */
