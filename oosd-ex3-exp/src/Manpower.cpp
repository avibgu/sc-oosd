/*
 * Manpower.cpp
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
#include "../h/Manpower.h"

Manpower::Manpower() {
	// TODO Auto-generated constructor stub

	this->manpower = -1;
}

Manpower::~Manpower() {
	// TODO Auto-generated destructor stub
}

int Manpower::calc(Task* task){

	task->accept( this );

	return this->manpower;
}

/**
 * the purpose of visit is to calculate the manpower of the given task.
 */

void Manpower::visit(SimpleTask* task){

	// calc load of SimpleTask and update 'this->manpower'
}

void Manpower::visit(ProjectTask* task){


}

void Manpower::visit(DedicatedTask* task){


}
