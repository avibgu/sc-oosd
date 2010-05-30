/*
 * Load.cpp
 *
 *  Created on: May 30, 2010
 *      Author: Avi
 */

#include <iostream>
#include <vector>
#include <string>

using namespace std;

#include "../h/TasksVisitor.h"
#include "../h/Task.h"
#include "../h/SimpleTask.h"
#include "../h/ProjectTask.h"
#include "../h/DedicatedTask.h"
#include "../h/Query.h"
#include "../h/Load.h"

Load::Load() {
	// TODO Auto-generated constructor stub

	this->load = -1;
}

Load::~Load() {
	// TODO Auto-generated destructor stub
}

float Load::calc(Task* task){

	task->accept( this );

	return this->load;
}

/**
 * the purpose of visit is to calculate the load of the given task.
 */

void Load::visit(SimpleTask* task){

	// calc load of SimpleTask and update 'this->load'
}

void Load::visit(ProjectTask* task){


}

void Load::visit(DedicatedTask* task){


}
