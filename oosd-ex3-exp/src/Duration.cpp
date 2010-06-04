/*
 * Duration.cpp
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
#include "../h/SimpleTask.h"
#include "../h/ProjectTask.h"
#include "../h/DedicatedTask.h"
#include "../h/Query.h"
#include "../h/Duration.h"

Duration::Duration() {

	this->_duration = 0;
}

Duration::~Duration() {}

int Duration::calc(Task* task){

	task->accept( this );

	return this->_duration;
}

/**
 * the purpose of visit is to calculate the duration of the given task.
 */

void Duration::visit(SimpleTask* task){

	this->_duration = task->getDuration();
}

void Duration::visit(ProjectTask* task){

	int sum = 0;

	for ( vector< Task* >::iterator iter = task->getTasks()->begin();
		  iter !=  task->getTasks()->end();
		  ++iter ){

		sum += this->calc( *iter );
	}

	this->_duration = sum;
}

void Duration::visit(DedicatedTask* task){

	int sum = task->getDuration();

	for ( vector< Task* >::iterator iter = task->getTasks()->begin();
		  iter !=  task->getTasks()->end();
		  ++iter ){

		sum += this->calc( *iter );
	}

	this->_duration = sum;
}
