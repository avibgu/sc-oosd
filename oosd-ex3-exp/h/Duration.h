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

public:

	Duration();

	virtual ~Duration();

	int calc(Task* task);

	int visit(SimpleTask* task);

	int visit(ProjectTask* task);

	int visit(DedicatedTask* task);
};

#endif /* DURATION_H_ */
