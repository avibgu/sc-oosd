/*
 * Task.cpp
 *
 *  Created on: May 23, 2010
 *      Author: shai
 */

#include "../h/Task.h"

Task::Task(string description) : m_description(description){

}

string Task::getDescription(){
	return m_description;
}

Task::~Task() {

}
