/*
 * SimpleTask.h
 *
 *  Created on: May 28, 2010
 *      Author: Avi
 */

#ifndef SIMPLETASK_H_
#define SIMPLETASK_H_

class Resource;
class TasksVisitor;

class SimpleTask : public virtual Task{

protected:

		int _duration;

		vector< Resource* >* _resources;	// not our responsibility..

public:

	SimpleTask();

	SimpleTask( int duration, string description, vector< Resource* >* resources );

	virtual ~SimpleTask();

	virtual void accept( TasksVisitor* v );

	virtual int getDuration();

	virtual vector< Resource* >* getResources();
};

#endif /* SIMPLETASK_H_ */
