/*
 * SimpleTask.cpp
 *
 *  Created on: May 23, 2010
 *      Author: shai
 */

#include "../h/SimpleTask.h"

SimpleTask::SimpleTask(string description, int duration, vector<Resource*> resources) : Task(description), m_duration(duration), m_resources(resources){

}

int SimpleTask::getDuration(){
	return m_duration;
}

vector<Resource*> SimpleTask::getResources(){
	return m_resources;
}

void SimpleTask::accept(TaskVisitor* visitor){
	visitor->visit(this);
}

SimpleTask::~SimpleTask() {
	vector<Resource*>::iterator iterator;
	for(iterator = m_resources.begin(); iterator != m_resources.end(); iterator++){
		delete *iterator;
	}
}
