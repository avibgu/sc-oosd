/*
 * Conflicts.cpp
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
#include "../h/Conflicts.h"

Conflicts::Conflicts() : _isEquipment( false ) {

	this->_conflicts.clear();
	this->_projectConflicts.clear();
}

Conflicts::~Conflicts() {}

set<string> Conflicts::calc(Task* task){

	this->_conflicts.clear();
	this->_projectConflicts.clear();

	task->accept( this );

	return this->_conflicts;
}

/**
 * the purpose of visit is to calculate the manpower of the given task.
 */

void Conflicts::visit(SimpleTask* task){

	for ( vector< Resource* >::iterator iter = task->getResources()->begin();
		  iter !=  task->getResources()->end();
		  ++iter ){

		(*iter)->accept( this );

		if ( this->_isEquipment ){

			if ( 1 == this->_projectConflicts.count( this->_equipmentName ) )
				this->_conflicts.insert( this->_equipmentName );

			this->_projectConflicts.insert( this->_equipmentName );
		}
	}
}

void Conflicts::visit(ProjectTask* task){

	this->_projectConflicts.clear();

	for ( vector< Task* >::iterator iter = task->getTasks()->begin();
		  iter !=  task->getTasks()->end();
		  ++iter ){

		(*iter)->accept( this );
	}
}

void Conflicts::visit(DedicatedTask* task){

	this->_projectConflicts.clear();

	for ( vector< Task* >::iterator iter = task->getTasks()->begin();
		  iter !=  task->getTasks()->end();
		  ++iter ){

		(*iter)->accept( this );
	}
}

void Conflicts::visit(Worker* resource){

	this->_isEquipment = false;
}

void Conflicts::visit(Equipment* resource){

	this->_isEquipment = true;
	this->_equipmentName = resource->getName();
}
