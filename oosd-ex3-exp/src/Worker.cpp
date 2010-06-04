/*
 * Worker.cpp
 *
 *  Created on: May 30, 2010
 *      Author: Avi
 */

#include <iostream>
#include <vector>
#include <string>

using namespace std;

#include "../h/ResourcesVisitor.h"
#include "../h/Resource.h"
#include "../h/Worker.h"

Worker::Worker() : _firstName( "first" ), _lastName( "last" ) {}

Worker::Worker( string first, string last ) : _firstName( first ), _lastName( last ) {}

Worker::~Worker() {}

void Worker::accept(ResourcesVisitor* v){

	v->visit( this );
}

string Worker::getName(){

	return this->_firstName + " " + this->_lastName;
}
