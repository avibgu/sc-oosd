/*
 * ProjectTask.h
 *
 *  Created on: May 28, 2010
 *      Author: Avi
 */

#ifndef PROJECTTASK_H_
#define PROJECTTASK_H_

template<class R>
class TasksVisitor;

class ProjectTask : public Task{

public:

	ProjectTask();

	virtual ~ProjectTask();

	template<class R>
	R accept(TasksVisitor<R>* v){}
};

#endif /* PROJECTTASK_H_ */
