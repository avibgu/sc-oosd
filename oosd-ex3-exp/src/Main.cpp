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

#include "../h/ResourcesVisitor.h"
#include "../h/Resource.h"
#include "../h/Worker.h"
#include "../h/Equipment.h"
#include "../h/TasksVisitor.h"
#include "../h/Task.h"
#include "../h/SimpleTask.h"
#include "../h/Query.h"
#include "../h/Duration.h"

int main(){

	Query<int>* dr = new Duration();

	Task* st = new SimpleTask(17, "st", new vector< Resource* >() );

	cout << "Duration: " << dr->calc( st ) << endl;

	delete( st );
	st = 0;

	delete( dr );
	dr = 0;

	return 0;
}
