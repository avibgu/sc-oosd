/*
 * SimpleTask.h
 *
 *  Created on: May 28, 2010
 *      Author: Avi
 */

#ifndef SIMPLETASK_H_
#define SIMPLETASK_H_

class TasksVisitor;

class SimpleTask : public Task{

public:

	SimpleTask();

	virtual ~SimpleTask();

	void accept(TasksVisitor* v);
};

#endif /* SIMPLETASK_H_ */
