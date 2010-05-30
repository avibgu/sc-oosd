/*
 * Duration.h
 *
 *  Created on: May 28, 2010
 *      Author: Avi
 */

#ifndef DURATION_H_
#define DURATION_H_

class Task;
class SimpleTask;
class ProjectTask;
class DedicatedTask;

class Duration: public Query<int> {

private:

	int duration;

public:

	Duration();

	virtual ~Duration();

	int calc(Task* task);

	void visit(SimpleTask* task);

	void visit(ProjectTask* task);

	void visit(DedicatedTask* task);
};

#endif /* DURATION_H_ */
