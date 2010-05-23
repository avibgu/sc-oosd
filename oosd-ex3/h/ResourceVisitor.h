/*
 * ResourceVisitor.h
 *
 *  Created on: May 23, 2010
 *      Author: shai
 */

#ifndef RESOURCEVISITOR_H_
#define RESOURCEVISITOR_H_

#include "../h/Worker.h"
//class Worker;
class ResourceVisitor {
public:
	ResourceVisitor();
	virtual ~ResourceVisitor();
	void visit(Worker* worker);
	//void visit(Machine machine);
};

#endif /* RESOURCEVISITOR_H_ */
