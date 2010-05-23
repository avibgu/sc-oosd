/*
 * Resource.h
 *
 *  Created on: May 23, 2010
 *      Author: shai
 */

#ifndef RESOURCE_H_
#define RESOURCE_H_

class ResourceVisitor;
class Resource {
public:
	virtual void accept(ResourceVisitor* visitor) = 0;

	//virtual ~Resource();
};

#endif /* RESOURCE_H_ */
