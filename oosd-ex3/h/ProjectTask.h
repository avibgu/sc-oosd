/*
 * ProjectTask.h
 *
 *  Created on: May 24, 2010
 *      Author: shai
 */

#ifndef PROJECTTASK_H_
#define PROJECTTASK_H_

#include "Task.h"
class TaskVisitor;
class ProjectTask: public virtual Task {
protected:
	vector<Task*> m_subTasks;
public:
	ProjectTask(string description, vector<Task*> subTasks);
	vector<Task*> getSubTasks();
	void accept(TaskVisitor* visitor);
	virtual ~ProjectTask();
};

#endif /* PROJECTTASK_H_ */
