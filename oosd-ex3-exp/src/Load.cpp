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

Load::Load() : _totalDuration( 0 ), _numOfResources ( 0 ) {}

Load::~Load() {}

float Load::calc(Task* task){

	this->_totalDuration = 0;
	this->_numOfResources = 0;

	task->accept( this );

	if ( 0 == this->_numOfResources ) return 0;

	return this->_totalDuration / this->_numOfResources;
}

/**
 * the purpose of visit is to calculate the load of the given task.
 */

void Load::visit(SimpleTask* task){

	task->getResources()->size();

	task->
}

void Load::visit(ProjectTask* task){


}

void Load::visit(DedicatedTask* task){


}
