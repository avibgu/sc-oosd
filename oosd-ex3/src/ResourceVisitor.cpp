/*
 * ResourceVisitor.cpp
 *
 *  Created on: May 23, 2010
 *      Author: shai
 */

#include "../h/ResourceVisitor.h"

ResourceVisitor::ResourceVisitor() {

}

void ResourceVisitor::visit(Worker* worker){
	cout << "I visited worker" << endl;
}

void ResourceVisitor::visit(Machine* machine){
	cout << "I visited machine" << endl;
}

ResourceVisitor::~ResourceVisitor() {

}
