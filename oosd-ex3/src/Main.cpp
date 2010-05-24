/*
 * Main.cpp
 *
 *  Created on: May 24, 2010
 *      Author: shai
 */
#include "../h/DedicatedTask.h"
#include "../h/Worker.h"
#include "../h/Machine.h"
int main(int argc, char** argv) {
	vector<Resource*> resources2;
	vector<Resource*> resources1;
	Resource* shai = new Worker("shai", "cantor");
	Resource* drill = new Machine(312);
	resources1.push_back(shai); resources1.push_back(drill);
	Task* do_this = new SimpleTask("do this", 2, resources2);
	vector<Task*> tasks1;
	tasks1.push_back(do_this);
	DedicatedTask* mainTask = new DedicatedTask("main task", 1, resources1 , tasks1);

	cout << "I am the " + mainTask->getDescription()<< endl;
	cout << "my duration is " << mainTask->getDuration()<< endl;
	cout << "my resources are " + ((Worker*)mainTask->getResources().at(0))->getFirstName() << ", "<< ((Machine*)mainTask->getResources().at(1))->getInventoryId() << endl;
    return 0;
}
