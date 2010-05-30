/*
 * DedicatedTask.cpp
 *
 *  Created on: May 28, 2010
 *      Author: Avi
 */

#include "../h/TasksVisitor.h"
#include "../h/Task.h"
#include "../h/DedicatedTask.h"

DedicatedTask::DedicatedTask() {
	// TODO Auto-generated constructor stub

}

DedicatedTask::~DedicatedTask() {
	// TODO Auto-generated destructor stub
}

void DedicatedTask::accept(TasksVisitor* v){

	v->visit( this );
}
