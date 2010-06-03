/*
 * Equipment.cpp
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
#include "../h/Equipment.h"

Equipment::Equipment() {
	// TODO Auto-generated constructor stub

}

Equipment::~Equipment() {
	// TODO Auto-generated destructor stub
}

void Equipment::accept(ResourcesVisitor* v){

	v->visit( this );
}
