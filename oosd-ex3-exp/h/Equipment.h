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

public:

	Equipment();

	virtual ~Equipment();

	void accept(ResourcesVisitor* v);
};

#endif /* EQUIPMENT_H_ */
