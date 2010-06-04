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

	Task* st1 = new SimpleTask( 17, "st1", new vector< Resource* >() );
	Task* st2 = new SimpleTask( 18, "st2", new vector< Resource* >() );

	vector< Task* >* tvec = new vector< Task* >();

	tvec->push_back(st1);
	tvec->push_back(st2);

	Task* pr = new ProjectTask( tvec, "this is a project task" );
	Task* ded = new DedicatedTask( 45, "this is a dedicated task", tvec, new vector< Resource* >() );

	Worker wr;
	Equipment eq;

// ask queries

	cout << "Duration1: " << dr->calc( st1 ) << endl;
	cout << "Duration2: " << dr->calc( st2 ) << endl;
	cout << "Duration3: " << dr->calc( pr ) << endl;
	cout << "Duration4: " << dr->calc( ded ) << endl;
	cout << "Name: " << wr.getName() << endl;
	cout << "IN: " << eq.getInventoryNumber() << endl;


//delete only elements, not containers

	if (0 != st1){ delete( st1 ); st1 = 0; }

	if (0 != st2){ delete( st2 ); st2 = 0; }

	if (0 != pr){ delete( pr ); pr = 0; }

	if (0 != ded){ delete( ded ); ded = 0; }

	if (0 != dr){ delete( dr ); dr = 0; }

	return 0;
}
