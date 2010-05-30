/*
 * ProjectTask.cpp
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
#include "../h/ProjectTask.h"

ProjectTask::ProjectTask() {
	// TODO Auto-generated constructor stub

}

ProjectTask::~ProjectTask() {
	// TODO Auto-generated destructor stub
}

void ProjectTask::accept(TasksVisitor* v){

	v->visit( this );
}
