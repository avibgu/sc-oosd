#ifndef DURATION_H_
#define DURATION_H_

#include "Query.h"

class Task;


class Duration : public Query<int> {

public:

	Duration();

	 int calc(Task* task);

	virtual ~Duration();
};

#endif /*DURATION_H_*/
