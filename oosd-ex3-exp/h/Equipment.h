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
	string _name;

public:

	Equipment();

	Equipment( int inventoryNumber, string name );

	virtual ~Equipment();

	void accept(ResourcesVisitor* v);

	int getInventoryNumber();

	string getName();
};

#endif /* EQUIPMENT_H_ */
