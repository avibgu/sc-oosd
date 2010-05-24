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

using namespace std;

class Task {
protected:
	string m_description;
public:
	Task(string description);
	string getDescription();
	virtual ~Task();
};

#endif /* TASK_H_ */
