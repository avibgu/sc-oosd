/*
 * Conflicts.cpp
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
#include "../h/Resource.h"
#include "../h/Conflicts.h"

Conflicts::Conflicts() {
	// TODO Auto-generated constructor stub

	this->conflicts = new vector<Resource*>();
}

Conflicts::~Conflicts() {
	// TODO Auto-generated destructor stub
	delete( this->conflicts );
}

vector<Resource*>* Conflicts::calc(Task* task){

	task->accept( this );

	return this->conflicts;
}

/**
 * the purpose of visit is to calculate the manpower of the given task.
 */

void Conflicts::visit(ProjectTask* task){

	// calc conflicts of ProjectTask and update 'this->conflicts'
}

void Conflicts::visit(DedicatedTask* task){


}
