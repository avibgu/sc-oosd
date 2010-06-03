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
class Worker;
class Equipment;

class Manpower : public Query<int>, public ResourcesVisitor {

private:

	int manpower;

	bool isWorker;

public:

	Manpower();

	virtual ~Manpower();

	int calc(Task* task);

	void visit(SimpleTask* task);

	void visit(ProjectTask* task);

	void visit(DedicatedTask* task);

	void visit(Worker* resource);

	void visit(Equipment* resource);
};

#endif /* MANPOWER_H_ */
