JAVAC ?= javac
JAVA ?= java
SOURCES := $(filter-out %Test.java,$(wildcard *.java))

.PHONY: all clean rundemo
all:
	$(JAVAC) $(SOURCES)

clean:
	rm -f *.class

rundemo: all
	$(JAVA) Demo
