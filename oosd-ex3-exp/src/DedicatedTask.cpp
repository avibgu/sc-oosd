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
	// TODO Auto-generated constructor stub
	this->_duration = -1;
}

DedicatedTask::DedicatedTask( int duration ) {
	// TODO Auto-generated constructor stub
	this->_duration = duration;
}

DedicatedTask::~DedicatedTask() {
	// TODO Auto-generated destructor stub
}

void DedicatedTask::accept( TasksVisitor* v ){

	v->visit( this );
}
