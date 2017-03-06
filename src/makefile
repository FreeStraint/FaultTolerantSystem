all: DataGenerator.class DataSorter.class

DataGenerator.class:DataGenerator.java ReadWriteFile.java
	javac DataGenerator.java ReadWriteFile.java

DataSorter.class: DataSorter.java Sorter.java Heapsort.java InsertionSort.java ReadWriteFile.java Watchdog.java Sorting.java
	javac DataSorter.java Sorter.java Heapsort.java InsertionSort.java ReadWriteFile.java Watchdog.java Sorting.java

clean:
	rm *.class