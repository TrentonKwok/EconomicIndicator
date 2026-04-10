# AVL Tree — OECD Economic Ranking System

## Overview
This project is an OECD economic ranking system built with an AVL tree, a self-balancing binary search tree.
It loads country data from CSV files and ranks OECD countries by GDP, GDP growth rate, and inflation rate.
A GUI is included to visualize both the AVL tree and a regular BST for comparison.

## Why AVL Tree?
An AVL tree is used because it maintains balance automatically after insertions.
This helps keep search and insertion operations efficient compared with a regular BST.

## Files
- `AVLTree.java` — AVL tree implementation
- `BST.java` — Regular BST (no balancing), used for comparison in the GUI
- `Country.java` — Stores country data (name, GDP, growth rate, inflation)
- `RankedCountry.java` — Wraps a `Country` with a datatype so it can be compared and used as a tree key
- `CountryList.java` — Holds the list of OECD countries
- `DataExtractor.java` — Reads and parses the CSV files
- `SequenceList.java` — A simple dynamic array list
- `RankGUI.java` — GUI to visualize the tree
- `Test.java` — Basic functionality test (no framework)
- `AVLTreeTest.java` — JUnit unit tests
- `Z_GDP.csv`, `Z_Growth.csv`, `Z_CPI.csv` — OECD economic data, they are from world bank.

## Features
- Load OECD economic data from World Bank CSV files
- Rank countries by GDP, GDP growth, and inflation
- Store ranking data in an AVL tree
- Compare AVL tree structure with a regular BST
- Visualize the trees through a Java GUI

## Notes
Place the JUnit JAR file and all CSV files in the project directory before compiling and running the project.

## Compilation

javac -cp .:junit-platform-console-standalone-1.11.4.jar *.java

## Running Tests

java -jar junit-platform-console-standalone-1.11.4.jar -cp . --scan-classpath

## Running the GUI

java RankGUI

Select a year and datatype (GDP / GROWTH / INFLATION), then click:
- Build Tree to display the AVL tree
- Build BST to display the regular BST for comparison