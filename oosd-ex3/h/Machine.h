/*
 * Machine.h
 *
 *  Created on: May 24, 2010
 *      Author: shai
 */

#ifndef MACHINE_H_
#define MACHINE_H_

#include <iostream>
#include <string>
#include "Resource.h"
using namespace std;
class ResourceVisitor;
class Machine: public Resource {
private:
	int m_inventoryId;
public:
	Machine(int inventoryId);
	int getInventoryId();
	void accept(ResourceVisitor* visitor);
	virtual ~Machine();

};

#endif /* MACHINE_H_ */
