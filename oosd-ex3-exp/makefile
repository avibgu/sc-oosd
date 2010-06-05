CC=g++

CFLAGS=-c -I"h" -I"h/test" -g3

SOURCES=src/Conflicts.cpp src/Duration.cpp src/Load.cpp src/Manpower.cpp src/SimpleTask.cpp src/Worker.cpp src/DedicatedTask.cpp src/Equipment.cpp src/Main.cpp src/ProjectTask.cpp src/Task.cpp

OBJECTS=$(SOURCES:.cpp=.o)

EXECUTABLE=ex3

all: clean1 $(EXECUTABLE) clean2
	
$(EXECUTABLE): $(OBJECTS)
	-mkdir bin
	$(CC) $(OBJECTS) -o $@

%.o: %.cpp
	$(CC) $(CFLAGS) $< -o $@

.PHONY: clean1 clean2
clean1:
	-rm -f *.o
	-rm -f src/*.o
	-rm -f h/*.o
	-rm -f *~
	-rm -f src/*~
	-rm -f h/*~
	-rm -f $(EXECUTABLE)
	-rm -f bin

clean2:
	-mv src/*.o bin/