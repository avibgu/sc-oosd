/*
 * Task.h
 *
 *  Created on: May 28, 2010
 *      Author: Avi
 */

#ifndef TASK_H_
#define TASK_H_

class TasksVisitor;

class Task {

public:

	virtual void accept(TasksVisitor* v) = 0;
};

#endif /* TASK_H_ */
