/*
 * DedicatedTask.h
 *
 *  Created on: May 28, 2010
 *      Author: Avi
 */

#ifndef DEDICATEDTASK_H_
#define DEDICATEDTASK_H_

template<class R>
class TasksVisitor;

class DedicatedTask : public Task{

public:

	DedicatedTask();

	virtual ~DedicatedTask();

	template<class R>
	R accept(TasksVisitor<R>* v){}
};

#endif /* DEDICATEDTASK_H_ */
