/*
 * ProjectTask.h
 *
 *  Created on: May 28, 2010
 *      Author: Avi
 */

#ifndef PROJECTTASK_H_
#define PROJECTTASK_H_

class TasksVisitor;

class ProjectTask : public Task{

public:

	ProjectTask();

	virtual ~ProjectTask();

	void accept(TasksVisitor* v);
};

#endif /* PROJECTTASK_H_ */
