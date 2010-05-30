/*
 * ProjectTask.h
 *
 *  Created on: May 28, 2010
 *      Author: Avi
 */

#ifndef PROJECTTASK_H_
#define PROJECTTASK_H_

class TasksVisitor;

class ProjectTask : public virtual Task{

public:

	ProjectTask();

	virtual ~ProjectTask();

	virtual void accept(TasksVisitor* v);	//TODO should be virtual?..
};

#endif /* PROJECTTASK_H_ */
