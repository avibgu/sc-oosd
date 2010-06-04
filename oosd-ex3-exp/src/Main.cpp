/*
 * Main.cpp
 *
 *  Created on: May 28, 2010
 *      Author: Avi
 */

#include <iostream>
#include <vector>
#include <string>
#include <set>

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

void test();

int main(){

// tests

	test();

// build hierarchy


// ask queries



//delete

	return 0;
}

void test(){

// build hierarchy

	Query<int>* dr = new Duration();
	Query<int>* mp = new Manpower();
	Query<float>* ld = new Load();
	Query< set<string> >* cf = new Conflicts();

	vector< Resource* >* res1 = new vector< Resource* >();
	vector< Resource* >* res2 = new vector< Resource* >();
	vector< Resource* >* res3 = new vector< Resource* >();

	Worker* w1 = new Worker("worker", "1");
	Worker* w2 = new Worker("worker", "2");
	Worker* w3 = new Worker("worker", "3");
	Worker* w4 = new Worker("worker", "4");

	res1->push_back( w1 );
	res1->push_back( w2 );
	res2->push_back( w1 );
	res2->push_back( w3 );
	res3->push_back( w4 );

	Task* st1 = new SimpleTask( 17, "st1", res1 );
	Task* st2 = new SimpleTask( 18, "st2", res2 );

	vector< Task* >* tvec = new vector< Task* >();

	tvec->push_back(st1);
	tvec->push_back(st2);

	Task* pr = new ProjectTask( tvec, "this is a project task" );
	Task* ded = new DedicatedTask( 45, "this is a dedicated task", tvec, res3 );


// ask queries

	cout << "Duration1: " << dr->calc( st1 ) << endl;
	cout << "Duration2: " << dr->calc( st2 ) << endl;
	cout << "Duration3: " << dr->calc( pr ) << endl;
	cout << "Duration4: " << dr->calc( ded ) << endl;

	cout << endl;

	cout << "Manpower: " << mp->calc( st1 ) << endl;
	cout << "Manpower: " << mp->calc( st2 ) << endl;
	cout << "Manpower: " << mp->calc( pr ) << endl;
	cout << "Manpower: " << mp->calc( ded ) << endl;

	cout << endl;

	cout << "Load: " << ld->calc( st1 ) << endl;
	cout << "Load: " << ld->calc( st2 ) << endl;
	cout << "Load: " << ld->calc( pr ) << endl;
	cout << "Load: " << ld->calc( ded ) << endl;

	cout << endl;

//	cout << "Conflicts: " << cf->calc( st1 ) << endl;
//	cout << "Conflicts: " << cf->calc( st2 ) << endl;
//	cout << "Conflicts: " << cf->calc( pr ) << endl;
//	cout << "Conflicts: " << cf->calc( ded ) << endl;

//delete

	if (0 != w1){ delete( w1 ); w1 = 0; }
	if (0 != w2){ delete( w2 ); w2 = 0; }
	if (0 != w3){ delete( w3 ); w3 = 0; }
	if (0 != w4){ delete( w4 ); w4 = 0; }

	if (0 != st1){ delete( st1 ); st1 = 0; }
	if (0 != st2){ delete( st2 ); st2 = 0; }
	if (0 != pr){ delete( pr ); pr = 0; }
	if (0 != ded){ delete( ded ); ded = 0; }

	if (0 != tvec){ delete( tvec ); tvec = 0; }
	if (0 != res1){ delete( res1 ); res1 = 0; }
	if (0 != res2){ delete( res2 ); res2 = 0; }
	if (0 != res3){ delete( res3 ); res3 = 0; }

	if (0 != dr){ delete( dr ); dr = 0; }
	if (0 != mp){ delete( mp ); mp = 0; }
	if (0 != ld){ delete( ld ); ld = 0; }
	if (0 != cf){ delete( cf ); cf = 0; }
}
