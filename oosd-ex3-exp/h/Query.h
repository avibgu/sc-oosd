/*
 * Query.h
 *
 *  Created on: May 28, 2010
 *      Author: Avi
 */

#ifndef QUERY_H_
#define QUERY_H_

class Task;

template<class R>
class Query : public TasksVisitor{

public:

	virtual R calc(Task* task) = 0;
};

#endif /* QUERY_H_ */
