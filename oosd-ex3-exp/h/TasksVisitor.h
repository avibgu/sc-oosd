/*
 * TasksVisitor.h
 *
 *  Created on: May 28, 2010
 *      Author: Avi
 */

#ifndef TASKSVISITOR_H_
#define TASKSVISITOR_H_

class SimpleTask;
class ProjectTask;
class DedicatedTask;

class TasksVisitor {

public:

	virtual void visit(SimpleTask* task) = 0;
	virtual void visit(ProjectTask* task) = 0;
	virtual void visit(DedicatedTask* task) = 0;
};

#endif /* TASKSVISITOR_H_ */
