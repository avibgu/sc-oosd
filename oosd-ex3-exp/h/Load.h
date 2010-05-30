/*
 * Load.h
 *
 *  Created on: May 30, 2010
 *      Author: Avi
 */

#ifndef LOAD_H_
#define LOAD_H_

class Task;
class SimpleTask;
class ProjectTask;
class DedicatedTask;

class Load : public Query<float> {

private:

	float load;

public:

	Load();

	virtual ~Load();

	float calc(Task* task);

	void visit(SimpleTask* task);

	void visit(ProjectTask* task);

	void visit(DedicatedTask* task);
};

#endif /* LOAD_H_ */
