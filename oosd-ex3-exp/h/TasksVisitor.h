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

template<class R>
class TasksVisitor {

	virtual R visit(SimpleTask* task) = 0;
	virtual R visit(ProjectTask* task) = 0;
	virtual R visit(DedicatedTask* task) = 0;
};

#endif /* TASKSVISITOR_H_ */
