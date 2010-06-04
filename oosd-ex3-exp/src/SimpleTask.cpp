/*
 * SimpleTask.cpp
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

SimpleTask::SimpleTask() : _duration( 0 ), _resources( 0 ) {

	_description = "simple task";
}

SimpleTask::SimpleTask( int duration, string description, vector< Resource* >* resources ):
										_duration( duration ), _resources( resources ) {

	_description = description;
}

SimpleTask::~SimpleTask() {}

void SimpleTask::accept(TasksVisitor* v){

	v->visit( this );
}

int SimpleTask::getDuration(){

	return this->_duration;
}

vector< Resource* >* SimpleTask::getResources(){

	return this->_resources;
}
