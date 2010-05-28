/*
 * Task.h
 *
 *  Created on: May 28, 2010
 *      Author: Avi
 */

#ifndef TASK_H_
#define TASK_H_

template<class R>
class TasksVisitor;

class Task {

public:

	template<class R>
	virtual R accept(TasksVisitor<R>* v) = 0;
};

#endif /* TASK_H_ */
