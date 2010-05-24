/*
 * SimpleTask.h
 *
 *  Created on: May 23, 2010
 *      Author: shai
 */

#ifndef SIMPLETASK_H_
#define SIMPLETASK_H_

#include "Task.h"
#include "../h/Resource.h"
class SimpleTask: public virtual Task {
protected:
	int m_duration;
	vector<Resource*> m_resources;
public:
	SimpleTask(string description, int duration, vector<Resource*> resources);
	int getDuration();
	vector<Resource*> getResources();
	virtual ~SimpleTask();
};

#endif /* SIMPLETASK_H_ */
