/*
 * Resource.h
 *
 *  Created on: May 30, 2010
 *      Author: Avi
 */

#ifndef RESOURCE_H_
#define RESOURCE_H_

class ResourcesVisitor;

class Resource {

public:

	virtual bool accept(ResourcesVisitor* v) = 0;
};

#endif /* RESOURCE_H_ */
