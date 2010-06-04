/*
 * Task.cpp
 *
 *  Created on: Jun 4, 2010
 *      Author: Avi
 */

#include <iostream>
#include <vector>
#include <string>

using namespace std;

#include "../h/Task.h"

Task::Task(){

	this->_description = "task";
}

Task::~Task(){

	//TODO
}

string Task::getDescription(){

	return this->_description;
}
