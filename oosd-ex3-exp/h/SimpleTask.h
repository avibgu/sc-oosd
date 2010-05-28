/*
 * SimpleTask.h
 *
 *  Created on: May 28, 2010
 *      Author: Avi
 */

#ifndef SIMPLETASK_H_
#define SIMPLETASK_H_

template<class R>
class TasksVisitor;

class SimpleTask : public Task{

public:

	SimpleTask();

	virtual ~SimpleTask();

	template<class R>
	R accept(TasksVisitor<R>* v);
};

#endif /* SIMPLETASK_H_ */
