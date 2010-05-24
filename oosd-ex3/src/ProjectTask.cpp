/*
 * ProjectTask.cpp
 *
 *  Created on: May 24, 2010
 *      Author: shai
 */

#include "../h/ProjectTask.h"

ProjectTask::ProjectTask(string description, vector<Task*> subTasks) : Task(description), m_subTasks(subTasks){

}

vector<Task*> ProjectTask::getSubTasks(){
	return m_subTasks;
}

void ProjectTask::accept(TaskVisitor* visitor){
	visitor->visit(this);
}

ProjectTask::~ProjectTask() {
	vector<Task*>::iterator iterator;
	for(iterator = m_subTasks.begin(); iterator != m_subTasks.end(); iterator++){
		delete *iterator;
	}
}
