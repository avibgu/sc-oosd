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

SimpleTask::SimpleTask() : _duration(-1){}

SimpleTask::SimpleTask( int duration ): _duration( duration ) {
	// TODO Auto-generated constructor stub
}

SimpleTask::~SimpleTask() {
	// TODO Auto-generated destructor stub
}

void SimpleTask::accept(TasksVisitor* v){

	v->visit( this );
}

int SimpleTask::getDuration(){

	return this->_duration;
}