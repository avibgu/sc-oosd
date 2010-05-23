/*
 * SimpleTask.h
 *
 *  Created on: May 23, 2010
 *      Author: shai
 */

#ifndef SIMPLETASK_H_
#define SIMPLETASK_H_

#include "Task.h"

class SimpleTask: public virtual Task {
private:
	vector<Resource*> m_resources;
public:
	SimpleTask(vector<Resource*> resources);
	virtual ~SimpleTask();
};

#endif /* SIMPLETASK_H_ */
