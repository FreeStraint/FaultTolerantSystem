make:
	javac *.java
	javah InsertionSort
	gcc -I $$JAVA_HOME/include -I $$JAVA_HOME/include/linux -shared -fpic -o libinsertionsort.so InsertionSort.c
	export LD_LIBRARY_PATH=$$LD_LIBRARY_PATH:.
clean:
	rm *.class
	rm *.h
	rm *.so
	rm *.txt
