//#ifndef REPORT_H_
//#define REPORT_H_
//
//
//class Task;
//class Query;
//class Duration;
//class Load;
//class Conflicts;
//
//
//class Report {
//
//private:
//
//	Task* _task;
//
//	vector< Query* >* _queries;
//
//	void print( Duration q ){
//
//			std::cout << "Duration: " << q.calc( _task ) << std::endl;
//	}
//
//	void print( Load q ){
//
//			std::cout << "Load: " << q.calc( _task ) << std::endl;
//	}
//
//	void print( Manpower q ){
//
//			std::cout << "Manpower: " << q.calc( _task ) << std::endl;
//	}
//
//	void print( Conflicts q ){
//
//		std::cout << "Conflicts: ";
//
//		set<string> conflictsSet = q.calc( _task );
//
//		for(	std::set<string>::iterator iter = conflictsSet.begin();
//				iter != conflictsSet.end();
//				++iter ) {
//
//			std::cout<< *iter << " ";
//		}
//
//		std::cout << std::endl;
//	}
//
//public:
//
//	report(	Task* task, vector< Query* >* queries ){
//
//		_task = task;
//		_queries = queries;
//	}
//
//	virtual ~report();
//
//	void printRepots(){
//
//		for (	vector<Query*>::iterator iter = _queries.begin();
//				iter != _queries.end();
//				++iter  )
//
//			print( *iter );
//	}
//};
//
//#endif /*REPORT_H_*/
