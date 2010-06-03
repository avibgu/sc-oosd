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

public:

	Worker();

	virtual ~Worker();

	void accept(ResourcesVisitor* v);
};

#endif /* WORKER_H_ */
