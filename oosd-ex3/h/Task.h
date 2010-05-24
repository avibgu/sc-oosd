/*
 * Task.h
 *
 *  Created on: May 23, 2010
 *      Author: shai
 */

#ifndef TASK_H_
#define TASK_H_

#include <string>
#include <vector>
#include "../h/TaskVisitor.h"
using namespace std;

class Task {
protected:
	string m_description;
public:
	Task(string description);
	string getDescription();
	virtual void accept(TaskVisitor* visitor) = 0;
	virtual ~Task();
};

#endif /* TASK_H_ */
