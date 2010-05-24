/*
 * Worker.h
 *
 *  Created on: May 23, 2010
 *      Author: shai
 */

#ifndef WORKER_H_
#define WORKER_H_

#include <iostream>
#include <string>
#include "Resource.h"
using namespace std;
class ResourceVisitor;
class Worker: public Resource {
private:
	string m_firstName;
	string m_lastName;
public:
	Worker(string firstName, string lastName);
	string getFirstName();
	string getLastName();
	void accept(ResourceVisitor* visitor);
	virtual ~Worker();
};

#endif /* WORKER_H_ */
