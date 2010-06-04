/*
 * Load.cpp
 *
 *  Created on: May 30, 2010
 *      Author: Avi
 */

#include <iostream>
#include <vector>
#include <string>
#include <set>

using namespace std;

#include "../h/ResourcesVisitor.h"
#include "../h/Resource.h"
#include "../h/TasksVisitor.h"
#include "../h/Task.h"
#include "../h/SimpleTask.h"
#include "../h/ProjectTask.h"
#include "../h/DedicatedTask.h"
#include "../h/Query.h"
#include "../h/Load.h"

Load::Load() : _totalDuration( 0 ) {

	_resources.clear();
}

Load::~Load() {}

float Load::calc(Task* task){

	this->_totalDuration = 0;
	this->_resources.clear();

	task->accept( this );

	if ( 0 == this->_resources.size() ) return 0;

	return this->_totalDuration / this->_resources.size();
}

/**
 * the purpose of visit is to calculate the load of the given task.
 */

void Load::visit(SimpleTask* task){

	this->_totalDuration += ( task->getResources()->size() * task->getDuration() );

	for ( vector< Resource* >::iterator iter = task->getResources()->begin();
		  iter !=  task->getResources()->end();
		  ++iter ){

		this->_resources.insert( (*iter)->getName() );
	}
}

void Load::visit(ProjectTask* task){

	for ( vector< Task* >::iterator iter = task->getTasks()->begin();
		  iter !=  task->getTasks()->end();
		  ++iter ){

		(*iter)->accept( this );
	}
}

void Load::visit(DedicatedTask* task){

	this->_totalDuration += ( task->getDuration() * task->getResources()->size() );

	for ( vector< Resource* >::iterator iter = task->getResources()->begin();
		  iter !=  task->getResources()->end();
		  ++iter ){

		this->_resources.insert( (*iter)->getName() );
	}

	for ( vector< Task* >::iterator iter = task->getTasks()->begin();
		  iter !=  task->getTasks()->end();
		  ++iter ){

		(*iter)->accept( this );
	}
}
