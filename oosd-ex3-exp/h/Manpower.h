/*
 * Manpower.h
 *
 *  Created on: May 30, 2010
 *      Author: Avi
 */

#ifndef MANPOWER_H_
#define MANPOWER_H_

class Task;
class SimpleTask;
class ProjectTask;
class DedicatedTask;

class Manpower : public Query<int> {

private:

	int manpower;

public:

	Manpower();

	virtual ~Manpower();

	int calc(Task* task);

	void visit(SimpleTask* task);

	void visit(ProjectTask* task);

	void visit(DedicatedTask* task);
};

#endif /* MANPOWER_H_ */
