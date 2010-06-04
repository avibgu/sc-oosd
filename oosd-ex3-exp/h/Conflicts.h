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

class Conflicts : public Query< set<string> >, public ResourcesVisitor{

private:

	set<string> _conflicts;
	set<string> _projectConflicts;

	bool _isEquipment;

	string _equipmentName;

public:

	Conflicts();

	virtual ~Conflicts();

	set<string> calc(Task* task);

	void visit(SimpleTask* task);

	void visit(ProjectTask* task);

	void visit(DedicatedTask* task);

	void visit(Worker* resource);

	void visit(Equipment* resource);
};

#endif /* CONFLICTS_H_ */
