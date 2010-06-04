/*
 * Worker.h
 *
 *  Created on: May 30, 2010
 *      Author: Avi
 */

#ifndef WORKER_H_
#define WORKER_H_

class ResourcesVisitor;

class Worker: public Resource {

	string _firstName;
	string _lastName;

public:

	Worker();

	Worker( string first, string last );

	virtual ~Worker();

	void accept(ResourcesVisitor* v);

	string getName();
};

#endif /* WORKER_H_ */
