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
	// TODO Auto-generated constructor stub
	this->duration = -1;

}

Duration::~Duration() {
	// TODO Auto-generated destructor stub
}

int Duration::calc(Task* task){

	task->accept( this );

	return this->duration;
}

/**
 * the purpose of visit is to calculate the duration of the given task.
 */

void Duration::visit(SimpleTask* task){

	// calc duration of SimpleTask and update 'this->duration'
}

void Duration::visit(ProjectTask* task){


}

void Duration::visit(DedicatedTask* task){


}
