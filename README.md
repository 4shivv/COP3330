# COP 3330 - Assignment 3

This directory contains Java implementations for COP 3330 Assignment 3, including a linked list data structure with file I/O operations and a coordinate parsing utility.

## Files

### LinkedList.java
A singly linked list implementation with custom processing logic.

**Features:**
- Add elements to the end of the list
- Process list according to specific rules (removes pairs where `next.item == current.item * 2 + 7` and replaces with counter values)
- Load integer data from a text file (space-separated, positive numbers only)
- Save list contents to a text file

**Key Methods:**
- `add(int item)` - Appends a new node to the list
- `processList()` - Applies transformation rules to the list
- `loadFromFile(String filename)` - Reads integers from a file
- `saveToFile(String filename)` - Writes list contents to a file

### LinkedListTester.java
Main test class that demonstrates LinkedList functionality.

**Workflow:**
1. Loads data from `data.txt`
2. Processes the linked list according to assignment rules
3. Saves the processed result to `processed.txt`

**Usage:**
```bash
javac assignment3/LinkedListTester.java
java assignment3.LinkedListTester
```

**Requirements:**
- Input file: `data.txt` (space-separated positive integers)
- Output file: `processed.txt` (generated after processing)

### Node.java (TreasureCoordinates.java)
**Note:** This file currently contains the `TreasureCoordinates` class, not a `Node` class. This appears to be a separate utility for parsing coordinate strings.

**Features:**
- Parses a string of digits enclosed in parentheses
- Generates all valid coordinate interpretations (x, y) with and without decimal points
- Validates coordinates (no leading zeros in whole numbers, no trailing zeros in decimals)

**Key Method:**
- `determineCoordinates(String coordinatesInput)` - Returns an ArrayList of valid coordinate strings

**Example:**
```java
TreasureCoordinates tc = new TreasureCoordinates();
ArrayList<String> coords = tc.determineCoordinates("(12345)");
// Returns possible interpretations like: "(1, 2345)", "(12, 345)", "(1.2, 345)", etc.
```

## Package Information
- **Package:** assignment3
- **Course:** COP 3330
- **Author:** Shivaganesh Nagamandla

## Notes

⚠️ **Missing Node class:** The LinkedList implementation references a `Node` class that should contain:
- Constructor: `Node(int item)`
- Getter: `getItem()`
- Getter: `getNext()`
- Setter: `setNext(Node next)`

This class needs to be implemented for LinkedList to function properly.

## Assignment Requirements
The linked list processing follows these rules:
1. Find consecutive nodes where `next.value == current.value * 2 + 7`
2. Delete both nodes when this pattern is found
3. Insert a counter value (starting at -100, incrementing) at the deletion point
4. Append the final counter value to the end of the list
