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

// test();

// build hierarchy

	Duration duration;
	Manpower manpower;
	Load load;
	Conflicts conflicts;

	Worker* joe = new Worker("Joe", "Cole");
	Worker* bob = new Worker("Bob", "Marley");
	Worker* sue = new Worker("Sue", "Oyunlari");
	Worker* sam = new Worker("Sam", "Oliver");
	Worker* kid = new Worker("Kid", "Johnson");

	Equipment* hammer = new Equipment(17, "hammer");
	Equipment* drill = new Equipment(23, "drill");
	Equipment* truck = new Equipment(96, "truck");

	// task-type (description, duration, [resources ] [sub-tasks ])

	vector< Resource* >* res1 = new vector< Resource* >();

	res1->push_back( kid );
	res1->push_back( drill );
	res1->push_back( truck );
	res1->push_back( bob );

	vector< Resource* >* res2 = new vector< Resource* >();

	res2->push_back( sue );
	res2->push_back( sam );

	vector< Resource* >* res3 = new vector< Resource* >();

	res3->push_back( sam );
	res3->push_back( drill );
	res3->push_back( kid );

	vector< Resource* >* res4 = new vector< Resource* >();

	res4->push_back( sam );
	res4->push_back( drill );
	res4->push_back( hammer );

	vector< Resource* >* res5 = new vector< Resource* >();

	res5->push_back( sam );
	res5->push_back( kid );
	res5->push_back( drill );
	res5->push_back( hammer );

	vector< Resource* >* res6 = new vector< Resource* >();

	res6->push_back( bob );
	res6->push_back( truck );
	res6->push_back( drill );
	res6->push_back( hammer );

	vector< Resource* >* res7 = new vector< Resource* >();

	res7->push_back( bob );
	res7->push_back( sue );

	vector< Resource* >* res8 = new vector< Resource* >();

	res8->push_back( bob );
	res8->push_back( kid );

	vector< Resource* >* res9 = new vector< Resource* >();

	res9->push_back( sam );
	res9->push_back( drill );
	res9->push_back( kid );
	res9->push_back( bob );

	vector< Resource* >* res10 = new vector< Resource* >();

	res10->push_back( sam );
	res10->push_back( truck );
	res10->push_back( kid );

	Task* simple1 = new SimpleTask( 4, "do this", res1 );
	Task* simple2 = new SimpleTask( 4, "do that", res2 );
	Task* simple3 = new SimpleTask( 1, "sub-task b", res3 );
	Task* simple4 = new SimpleTask( 2, "sub-task c", res4 );
	Task* simple5 = new SimpleTask( 1, "put a nail", res5 );
	Task* simple6 = new SimpleTask( 2, "break a wall", res6 );
	Task* simple7 = new SimpleTask( 2, "something", res7 );
	Task* simple8 = new SimpleTask( 4, "something else", res8 );
	Task* simple9 = new SimpleTask( 4, "make a hole", res9 );
	Task* simple10 = new SimpleTask( 4, "drive kid home", res10 );


	vector< Task* >* tasks1 = new vector< Task* >();

	tasks1->push_back( simple1 );
	tasks1->push_back( simple2 );

	vector< Resource* >* res11 = new vector< Resource* >();

	res11->push_back( kid );
	res11->push_back( sam );
	res11->push_back( truck );
	res11->push_back( drill );

	Task* dedicated2 = new DedicatedTask( 3, "sub-task a", tasks1, res11 );

	vector< Task* >* tasks2 = new vector< Task* >();

	tasks2->push_back( simple9 );
	tasks2->push_back( simple10 );

	vector< Resource* >* res12 = new vector< Resource* >();

	res12->push_back( sam );
	res12->push_back( hammer );
	res12->push_back( truck );
	res12->push_back( kid );

	Task* dedicated3 = new DedicatedTask( 3, "sub-sub-sub task", tasks2, res12 );

	vector< Task* >* tasks3 = new vector< Task* >();

	tasks3->push_back( simple7 );
	tasks3->push_back( simple8 );
	tasks3->push_back( dedicated3 );

	Task* project2 = new ProjectTask( "sub-sub task", tasks3 );

	vector< Task* >* tasks4 = new vector< Task* >();

	tasks4->push_back( simple5 );
	tasks4->push_back( simple6 );
	tasks4->push_back( project2 );

	Task* project1 = new ProjectTask( "sub-task d", tasks4 );

	vector< Task* >* tasks5 = new vector< Task* >();

	tasks5->push_back( dedicated2 );
	tasks5->push_back( simple3 );
	tasks5->push_back( simple4 );
	tasks5->push_back( project1 );

	vector< Resource* >* res13 = new vector< Resource* >();

	res13->push_back( sue );
	res13->push_back( kid );

	Task* dedicated1 = new DedicatedTask( 1, "sub-sub-sub task", tasks5, res12 );

// ask queries

	cout << "Duration: " << duration.calc( dedicated1 ) << endl;
	cout << "Manpower: " << manpower.calc( dedicated1 ) << endl;
	cout << "Load: " << load.calc( dedicated1 ) << endl;
	cout << "Conflicts: ";

	set<string> conflictsSet = conflicts.calc( dedicated1 );

    for(	set<string>::iterator iter = conflictsSet.begin();
    		iter != conflictsSet.end();
    		++iter ) {

		cout<< *iter;
    }

	cout << endl;


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

	Task* pr = new ProjectTask( "this is a project task", tvec );
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
