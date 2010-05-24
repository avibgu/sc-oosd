/*
 * TaskVisitor.h
 *
 *  Created on: May 24, 2010
 *      Author: shai
 */

#ifndef TASKVISITOR_H_
#define TASKVISITOR_H_
class SimpleTask;
class ProjectTask;
class DedicatedTask;
class TaskVisitor {
public:
	TaskVisitor();
	void visit(SimpleTask* task);
	void visit(ProjectTask* task);
	void visit(DedicatedTask* task);
	virtual ~TaskVisitor();
};

#endif /* TASKVISITOR_H_ */
