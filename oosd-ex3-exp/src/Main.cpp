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
#include "../h/ProjectTask.h"
#include "../h/DedicatedTask.h"
#include "../h/Query.h"
#include "../h/Conflicts.h"
#include "../h/Duration.h"
#include "../h/Load.h"
#include "../h/ManPower.h"

int main(){

// build hierarchy

	Query<int>* dr = new Duration();

	Task* st = new SimpleTask( 17, "st", new vector< Resource* >() );


// ask queries

	cout << "Duration: " << dr->calc( st ) << endl;


//delete only elements, not containers

	if (0 != st){

		delete( st );
		st = 0;
	}

	if (0 != dr){

		delete( dr );
		dr = 0;
	}

	return 0;
}
