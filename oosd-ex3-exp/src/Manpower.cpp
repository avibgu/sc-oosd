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
#include "../h/Resource.h"
#include "../h/ResourcesVisitor.h"
#include "../h/Worker.h"
#include "../h/Equipment.h"
#include "../h/Manpower.h"

Manpower::Manpower() {
	// TODO Auto-generated constructor stub

	this->manpower = -1;
	this->isWorker = false;
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

	this->manpower = 0;

	for ( vector< Resource* >::iterator iter = task->getResources()->begin();
		  iter !=  task->getResources()->end();
		  ++iter ){


	}

}

void Manpower::visit(ProjectTask* task){


}

void Manpower::visit(DedicatedTask* task){


}

void Manpower::visit(Worker* resource){

	this->isWorker = true;
}

void Manpower::visit(Equipment* resource){

	this->isWorker = false;
}


