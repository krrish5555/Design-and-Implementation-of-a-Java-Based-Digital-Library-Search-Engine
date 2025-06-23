# Design-and-Implementation-of-a-Java-Based-Digital-Library-Search-Engine
A Java application that allows users to load, search, view, and sort a digital library of books using custom sorting algorithms (Bubble Sort, Insertion Sort, Quick Sort). It features a menu-driven interface, keyword-based search, user interaction logging, and file-based serialization for data persistence across sessions.

In this project, I developed a menu-driven digital library system in Java that allows users to search, view, sort, log, and persistently store information about books. The application reads book data from a file, processes it into Book objects, and stores them in a collection for efficient retrieval and manipulation.

📚 Key Features Implemented:
File Parsing and Object Creation:

Implemented loadBooks() in the Library class to read lines from books.txt, parse book title, author, and publication year, and instantiate Book objects accordingly.

Sorting Algorithms:

Implemented classic sorting algorithms:

bubbleSort() in SortUtil to sort books by title.

insertionSort() to sort by author.

quickSort() to sort by publication year.


Search Functionality:

Developed a keyword-based search method that allows users to search books by title, author, or publication year in a case-insensitive manner.


Menu-Driven User Interface:

Designed the LibraryMenu class with an interactive menu allowing users to:

View all books.

Sort by title, author, or year.

Search for books using a keyword.

Exit the application.


User Interaction Logging:

Created a UserInteractionLogger class that logs each action (search, view, sort) to a file (user_interactions.log) with a timestamp using FileWriter.


Data Persistence with Serialization:

Used ObjectOutputStream and ObjectInputStream to serialize and deserialize the Book list to/from library.ser, ensuring continuity of state across sessions.


Main Application Flow:

The Main class initiates the program, loads existing serialized data if available, or reads from the file otherwise. Upon exit, it saves the current state.


✅ Technologies Used:
Java I/O (BufferedReader, FileWriter, Object Streams)

Java Collections (List, ArrayList)

Custom Comparators

Serialization

Modular class design
