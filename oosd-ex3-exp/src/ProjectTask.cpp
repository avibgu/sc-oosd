/*
 * ProjectTask.cpp
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
#include "../h/ProjectTask.h"

ProjectTask::ProjectTask() {

	this->_tasks = new vector< Task* >();
	_description = "project task";
}

ProjectTask::ProjectTask( vector< Task* >* tasks, string description ){

	this->_tasks = tasks;
	_description = description;
}

ProjectTask::~ProjectTask() {

	if ( 0 != this->_tasks){

		delete( this->_tasks );
		this->_tasks = 0;
	}
}

void ProjectTask::accept(TasksVisitor* v){

	v->visit( this );
}

vector< Task* >* ProjectTask::getTasks(){

	return this->_tasks;
}
