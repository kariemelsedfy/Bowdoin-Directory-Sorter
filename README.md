# Java Data Structures Project: Directory Sorting

## Overview
This project, developed for the Data Structures class at Bowdoin College, implements custom data structures and sorting algorithms. The primary focus is to create, manipulate, and sort a directory of students based on various criteria using a `SortableArrayList` and custom comparators.

## Features
- **AbstractSimpleList**: A base class providing a minimal implementation of the `List` interface.
- **SimpleArrayList**: A dynamically resizable array-backed list supporting basic list operations.
- **SortableArrayList**: Extends `SimpleArrayList` to add custom sorting capabilities using comparators.
- **Directory Sorting**: Sorts student data based on:
  - Smallest/Largest SU box number
  - Lexicographical order by last name
  - Number of vowels in the name
  - "Fanciest" phone number (most repeated digits)

## How It Works
1. **Directory Loading**: Reads student information from `directory.txt` and populates a `SortableArrayList`.
2. **Sorting Algorithms**: Implements selection sort tailored for custom comparators.
3. **Custom Comparators**: Defines specific sorting criteria for each type of comparison (e.g., SU box number, last name).
4. **Output**: Displays sorted results for each criterion.

## Files
- **AbstractSimpleList.java**: Base implementation of the `List` interface.
- **SimpleArrayList.java**: Dynamic array-backed implementation of a list.
- **SortableArrayList.java**: Adds sorting capabilities to `SimpleArrayList`.
- **DirectorySort.java**: Main class for sorting and displaying student data.
- **Student.java**: Represents individual student records.
- **directory.txt**: Input file containing student data.

## Highlights
- **Custom Data Structures**: Implements list and sorting functionality from scratch.
- **Comparator-based Sorting**: Flexible sorting logic using custom comparators.
- **File Parsing**: Reads and processes structured input data.

## Future Improvements
- Add support for more complex sorting criteria.
- Enhance the file parsing logic to handle errors or invalid formats.
- Integrate a GUI or web-based interface for easier interaction.

## Author
- Karim ElSedfy

