/*
 * Main.cpp
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
#include "../h/Query.h"
#include "../h/Duration.h"

int main(){

	Query<int>* dr = new Duration();

	Task* st = new SimpleTask(17);

	cout << "Duration: " << dr->calc( st ) << endl;

	return 0;
}
