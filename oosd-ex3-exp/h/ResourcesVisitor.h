/*
 * ResourcesVisitor.h
 *
 *  Created on: May 30, 2010
 *      Author: Avi
 */

#ifndef RESOURCESVISITOR_H_
#define RESOURCESVISITOR_H_

class Worker;
class Equipment;

class ResourcesVisitor {

public:

	virtual void visit(Worker* resource) = 0;
	virtual void visit(Equipment* resource) = 0;
};

#endif /* RESOURCESVISITOR_H_ */
