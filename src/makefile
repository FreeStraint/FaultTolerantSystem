all: DataGenerator.class DataSorter.class

DataGenerator.class:DataGenerator.java ReadWriteFile.java
	javac DataGenerator.java ReadWriteFile.java

DataSorter.class: DataSorter.java Sorter.java Heapsort.java InsertionSort.java ReadWriteFile.java Watchdog.java Sorting.java
	javac DataSorter.java Sorter.java Heapsort.java InsertionSort.java ReadWriteFile.java Watchdog.java Sorting.java

libinsertionsort.jnilib: InsertionSort.c InsertionSort.java
	javac InsertionSort.java
	javah InsertionSort
	gcc -I $JAVA_HOME/include -I $JAVA_HOME/include/linux -shared -fpic -o libinsertionsort.so InsertionSort.c
	export LD_LIBRARY_PATH=$LD_LIBRARY_PATH:.

clean:
	rm *.class
	rm *.txt
	rm *.h
	rm *.so