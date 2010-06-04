/*
 * Manpower.cpp
 *
 *  Created on: May 30, 2010
 *      Author: Avi
 */

#include <iostream>
#include <vector>
#include <string>
#include <set>

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

Manpower::Manpower() : _isWorker( false ), _workerName( "" ) {

	this->_manpower.clear();
}

Manpower::~Manpower() {}

int Manpower::calc(Task* task){

	this->_manpower.clear();

	task->accept( this );

	return this->_manpower.size();
}

/**
 * the purpose of visit is to calculate the manpower of the given task.
 */

void Manpower::visit(SimpleTask* task){

	for ( vector< Resource* >::iterator iter = task->getResources()->begin();
		  iter !=  task->getResources()->end();
		  ++iter ){

		(*iter)->accept( this );

		if ( this->_isWorker ) this->_manpower.insert( this->_workerName );
	}
}

void Manpower::visit(ProjectTask* task){

	for ( vector< Task* >::iterator iter = task->getTasks()->begin();
		  iter !=  task->getTasks()->end();
		  ++iter ){

		(*iter)->accept( this );
	}
}

void Manpower::visit(DedicatedTask* task){

	for ( vector< Resource* >::iterator iter = task->getResources()->begin();
		  iter !=  task->getResources()->end();
		  ++iter ){

		(*iter)->accept( this );

		if ( this->_isWorker ) this->_manpower.insert( this->_workerName );
	}

	for ( vector< Task* >::iterator iter = task->getTasks()->begin();
		  iter !=  task->getTasks()->end();
		  ++iter ){

		(*iter)->accept( this );
	}
}

void Manpower::visit(Worker* resource){

	this->_isWorker = true;
	this->_workerName = resource->getName();
}

void Manpower::visit(Equipment* resource){

	this->_isWorker = false;
}


