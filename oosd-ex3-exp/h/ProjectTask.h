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

protected:

	vector< Task* >* _tasks;	// shallow delete only..

public:

	ProjectTask();

	ProjectTask( vector< Task* >* tasks, string description );

	virtual ~ProjectTask();

	virtual void accept( TasksVisitor* v );	//TODO should be virtual?..

	virtual vector< Task* >* getTasks();
};

#endif /* PROJECTTASK_H_ */
