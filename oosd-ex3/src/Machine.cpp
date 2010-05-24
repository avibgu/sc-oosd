/*
 * Machine.cpp
 *
 *  Created on: May 24, 2010
 *      Author: shai
 */

#include "../h/Machine.h"

Machine::Machine(int inventoryId) : m_inventoryId(inventoryId){

}

int Machine::getInventoryId(){
	return m_inventoryId;
}

void Machine::accept(ResourceVisitor* visitor){
	visitor->visit(this);
}

Machine::~Machine() {

}
