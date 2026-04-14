# AVL Tree — Economic Ranking System

## Overview
This project is a country economic ranking system built with an AVL tree, a self-balancing binary search tree.
It loads country data from CSV files and ranks countries by GDP, GDP growth rate, and inflation rate.
The program also includes a regular BST for comparison and a GUI for visualization.

## Why AVL Tree?
I chose an AVL tree because a regular BST can become unbalanced, especially when data is inserted in order.
An AVL tree keeps itself balanced by using rotations after insertions and deletions.
Because of this, operations such as search, insertion, and deletion stay efficient.

## Files
- `AVLTree.java` — AVL tree implementation, it can use iterator
- `BST.java` — Regular binary search tree used for comparison
- `Country.java` — Stores country data such as GDP, growth rate, and inflation
- `RankedCountry.java` — Wraps a country and a selected metric so it can be used as a tree key
- `CountryList.java` — Stores the selected country group (such as OECD, G7, G20, BRICS, or custom)
- `DataExtractor.java` — Reads and parses CSV data files, uses AVL tree Iterator for traversal
- `SequenceList.java` — Simple dynamic array list implementation
- `SymbolTable.java` — Symbol table used in the project
- `RankGUI.java` — GUI for building and visualizing the AVL tree and BST
- `Test.java` — Simple main-method test without a testing framework
- `AVLTreeTest.java` — JUnit unit tests for the AVL tree
- `Z_GDP.csv`, `Z_Growth.csv`, `Z_CPI.csv` — Economic data files used by the program

## Features
- Read country data from CSV files
- Let the user choose different country groups such as OECD, G7, G20, BRICS, or a custom list
- Rank countries by GDP, GDP growth, or inflation
- Build the ranking with an AVL tree
- Show the difference between an AVL tree and a regular BST
- Display the result in a Java GUI

## Requirements
- Java JDK installed
- All `.java` source files in the same project directory
- CSV data files (`Z_GDP.csv`, `Z_Growth.csv`, `Z_CPI.csv`) in the same directory
- JUnit standalone JAR in the same directory if you want to run JUnit tests

## Compilation

### Compile the main program
javac AVLTree.java BST.java Country.java CountryList.java DataExtractor.java RankedCountry.java RankGUI.java SequenceList.java SymbolTable.java Test.java

### Compile with JUnit tests (macOS/Linux)
javac -cp .:junit-platform-console-standalone-1.11.4.jar *.java

### Compile with JUnit tests (Windows)
javac -cp ".;junit-platform-console-standalone-1.11.4.jar" *.java

## Running Tests

### Run the basic non-JUnit test
java Test

### Run JUnit tests
java -jar junit-platform-console-standalone-1.11.4.jar -cp . --scan-classpath

## Running the GUI
java RankGUI

After the GUI opens:
1. Select a country group
2. Select a year
3. Select a datatype (GDP, GROWTH, or INFLATION)
4. Click Build Tree to build and display the AVL tree
5. Click Build BST to build and display the regular BST for comparison

## Test Coverage
The JUnit tests in `AVLTreeTest.java` cover:
- insertion and retrieval
- searching for non-existent keys
- size, emptiness, contains, minimum, and maximum
- updating an existing key
- LL, RR, LR, and RL rotations
- deletion of a leaf node
- deletion of a node with one child
- deletion of a node with two children
- deleting a non-existent key
- large sequential and random insertions to check AVL height behavior
