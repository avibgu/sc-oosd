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

ProjectTask::ProjectTask() : _tasks( 0 ) {

	_description = "project task";
}

ProjectTask::ProjectTask( string description, vector< Task* >* tasks ) : _tasks( tasks ) {

	_description = description;
}

ProjectTask::~ProjectTask() {}

void ProjectTask::accept(TasksVisitor* v){

	v->visit( this );
}

vector< Task* >* ProjectTask::getTasks(){

	return this->_tasks;
}
