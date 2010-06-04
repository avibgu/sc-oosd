/*
 * Equipment.cpp
 *
 *  Created on: May 30, 2010
 *      Author: Avi
 */

#include <iostream>
#include <vector>
#include <string>
#include <cstdlib>

using namespace std;

#include "../h/ResourcesVisitor.h"
#include "../h/Resource.h"
#include "../h/Equipment.h"

Equipment::Equipment() {

	this->_inventoryNumber = rand();
}

Equipment::Equipment( int inventoryNumber ){

	this->_inventoryNumber = inventoryNumber;
}

Equipment::~Equipment() {
	// TODO Auto-generated destructor stub
}

void Equipment::accept(ResourcesVisitor* v){

	v->visit( this );
}

int Equipment::getInventoryNumber(){

	return this->_inventoryNumber;
}
