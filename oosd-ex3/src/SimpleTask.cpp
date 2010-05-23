/*
 * SimpleTask.cpp
 *
 *  Created on: May 23, 2010
 *      Author: shai
 */

#include "../h/SimpleTask.h"

SimpleTask::SimpleTask(vector<Resource*> resources) : m_resources(resources){

}

SimpleTask::~SimpleTask() {
	vector<Resource*>::iterator iterator;
	for(iterator = m_resources.begin(); iterator != m_resources.end(); iterator++){
		delete *iterator;
	}
}
