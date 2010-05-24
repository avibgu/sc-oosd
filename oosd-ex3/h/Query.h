#ifndef QUERY_H_
#define QUERY_H_

class Task;

template <class R>

class Query{

public:

	virtual R calc( Task* task ) = 0;

};

#endif /*QUERY_H_*/
