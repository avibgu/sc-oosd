/*
 * Equipment.h
 *
 *  Created on: May 30, 2010
 *      Author: Avi
 */

#ifndef EQUIPMENT_H_
#define EQUIPMENT_H_

class ResourcesVisitor;

class Equipment: public Resource {

	int _inventoryNumber;

public:

	Equipment();

	Equipment( int inventoryNumber );

	virtual ~Equipment();

	void accept(ResourcesVisitor* v);

	int getInventoryNumber();
};

#endif /* EQUIPMENT_H_ */
