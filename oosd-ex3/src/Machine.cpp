/*
 * Machine.cpp
 *
 *  Created on: May 24, 2010
 *      Author: shai
 */

#include "../h/Machine.h"

Machine::Machine(int inventoryId) : m_inventoryId(inventoryId){

}

Machine::~Machine() {

}

void Machine::accept(ResourceVisitor* visitor){
	visitor->visit(this);
}
