/*
 * DedicatedTask.cpp
 *
 *  Created on: May 28, 2010
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

DedicatedTask::DedicatedTask(){

	_description = "dedicated task";
	_duration = -1;
	_resources = new vector< Resource* >();
	_tasks = new vector< Task* >();
}

DedicatedTask::DedicatedTask( int duration, string description, vector< Task* >* tasks,
							  vector< Resource* >* resources ) {

	_description = description;
	_duration = duration;
	_resources = resources;
	_tasks = tasks;
}

DedicatedTask::~DedicatedTask() {}

void DedicatedTask::accept( TasksVisitor* v ){

	v->visit( this );
}
