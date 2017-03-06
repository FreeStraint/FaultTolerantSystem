all: DataGenerator.class DataSorter.class

DataGenerator.class:DataGenerator.java ReadWriteFile.java
	javac DataGenerator.java ReadWriteFile.java

DataSorter.class: libinsertionsort.jnilib DataSorter.java Sorter.java Heapsort.java InsertionSort.java ReadWriteFile.java Watchdog.java Sorting.java
	javac DataSorter.java Sorter.java Heapsort.java InsertionSort.java ReadWriteFile.java Watchdog.java Sorting.java

libinsertionsort.jnilib: InsertionSort.c InsertionSort.java
	javac InsertionSort.java
	javah InsertionSort
	gcc -dynamiclib -I /Library/Java/JavaVirtualMachines/jdk1.8.0_111.jdk/Contents/Home/include/ InsertionSort.c -o libinsertionsort.jnilib

clean:
	rm *.class
	rm *.txt