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

Equipment::Equipment() : _inventoryNumber( rand() ), _name( "equipment" ) {}

Equipment::Equipment( int inventoryNumber, string name ) : _inventoryNumber( inventoryNumber ),
														   _name( name ) {}

Equipment::~Equipment() {}

void Equipment::accept(ResourcesVisitor* v){

	v->visit( this );
}

int Equipment::getInventoryNumber(){

	return this->_inventoryNumber;
}

string Equipment::getName(){

	return this->_name;
}
