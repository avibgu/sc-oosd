/*
 * DedicatedTask.h
 *
 *  Created on: May 24, 2010
 *      Author: shai
 */

#ifndef DEDICATEDTASK_H_
#define DEDICATEDTASK_H_

#include "ProjectTask.h"
#include "SimpleTask.h"

class DedicatedTask: public ProjectTask, public SimpleTask {
public:
	DedicatedTask(string description, int duration, vector<Resource*> resources, vector<Task*> subTasks);
	virtual ~DedicatedTask();
};

#endif /* DEDICATEDTASK_H_ */
