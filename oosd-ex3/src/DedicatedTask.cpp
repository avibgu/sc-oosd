/*
 * DedicatedTask.cpp
 *
 *  Created on: May 24, 2010
 *      Author: shai
 */

#include "../h/DedicatedTask.h"

DedicatedTask::DedicatedTask(string description, int duration, vector<Resource*> resources, vector<Task*> subTasks):
Task(description), ProjectTask(description, subTasks), SimpleTask(description, duration, resources){


}

void DedicatedTask::accept(TaskVisitor* visitor){
	visitor->visit(this);
}

DedicatedTask::~DedicatedTask() {

}
