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

}

Duration::~Duration() {
	// TODO Auto-generated destructor stub
}

int Duration::calc(Task* task){

	return task.accept( this );
}

/**
 * the purpose of visit is to calculate the duration of the given task.
 */

int Duration::visit(SimpleTask* task){

	return 0;
}

int Duration::visit(ProjectTask* task){

	return 0;
}

int Duration::visit(DedicatedTask* task){

	return 0;
}
