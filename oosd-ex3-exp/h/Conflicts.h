/*
 * Conflicts.h
 *
 *  Created on: May 30, 2010
 *      Author: Avi
 */

#ifndef CONFLICTS_H_
#define CONFLICTS_H_

class Task;
class ProjectTask;
class DedicatedTask;
class Resource;
class Worker;
class Equipment;

class Conflicts : public Query< vector<Resource*>* >, public ResourcesVisitor{

private:

	vector<Resource*>* conflicts;

	bool isEquipment;

public:

	Conflicts();

	virtual ~Conflicts();

	vector<Resource*>* calc(Task* task);

	void visit(ProjectTask* task);

	void visit(DedicatedTask* task);

	void visit(Worker* resource);

	void visit(Equipment* resource);
};

#endif /* CONFLICTS_H_ */
