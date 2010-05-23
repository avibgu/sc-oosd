/*
 * Main.cpp
 *
 *  Created on: May 24, 2010
 *      Author: shai
 */

#include "../h/Worker.h"
#include "../h/Machine.h"
int main(int argc, char** argv) {

	Resource* sam = new Worker("sam", "something");
	Resource* drill = new Machine(567);
	ResourceVisitor* visitor = new ResourceVisitor();
    sam->accept(visitor);
    drill->accept(visitor);

    delete sam;
	delete drill;
	delete visitor;

    return 0;
}
