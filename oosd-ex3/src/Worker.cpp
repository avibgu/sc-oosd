/*
 * Worker.cpp
 *
 *  Created on: May 23, 2010
 *      Author: shai
 */

#include "../h/Worker.h"

Worker::Worker(string firstName, string lastName): m_firstName(firstName), m_lastName(lastName) {

}

Worker::~Worker() {

}

void Worker::accept(ResourceVisitor* visitor) {
	visitor->visit(this);
}
