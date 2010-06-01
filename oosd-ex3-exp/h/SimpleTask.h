/*
 * SimpleTask.h
 *
 *  Created on: May 28, 2010
 *      Author: Avi
 */

#ifndef SIMPLETASK_H_
#define SIMPLETASK_H_

class TasksVisitor;

class SimpleTask : public virtual Task{

protected:

		int _duration;

public:

	SimpleTask();

	SimpleTask( int duration );

	virtual ~SimpleTask();

	virtual void accept( TasksVisitor* v );	//TODO should be virtual?..

	int getDuration();
};

#endif /* SIMPLETASK_H_ */
