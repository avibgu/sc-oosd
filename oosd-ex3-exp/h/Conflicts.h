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

class Conflicts : Query< vector<Resource*>* >{

private:

	vector<Resource*>* conflicts;

public:

	Conflicts();

	virtual ~Conflicts();

	vector<Resource*>* calc(Task* task);

	void visit(ProjectTask* task);

	void visit(DedicatedTask* task);
};

#endif /* CONFLICTS_H_ */
