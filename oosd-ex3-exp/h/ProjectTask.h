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

	vector< Task* >* _tasks;	// not our responsibility..

public:

	ProjectTask();

	ProjectTask( string description, vector< Task* >* tasks );

	virtual ~ProjectTask();

	virtual void accept( TasksVisitor* v );

	virtual vector< Task* >* getTasks();
};

#endif /* PROJECTTASK_H_ */
