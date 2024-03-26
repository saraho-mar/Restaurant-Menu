# Restaurant-Menu

Part 1: Develop a program that models a simple restaurant with one chef and one waiter.
Your program should have the following classes:
• A class Restaurant
• A class Chef (extends Thread)
• A class Waiter (extends Thread)
• A class Dish
The restaurant class will need a collection to store dish objects. The waiter picks up a dish
from the collection and passes it to the Chef and starts the chef’s thread. Assume the
preparation of a meal takes a fixed amount of time and when this elapses the chef’s thread
notifies the waiter, using notify(). While the meal is in preparation, the waiter waits for the
meal, using wait().
Note, wait() and notify() must be called within synchronized methods or blocks.
Hint: Have one thread for the waiter that continues to run until all dish objects in the
collection have been processed and have one other thread for the chef that continues to run
until all dish objects in the collected have been prepared.
Part 2: Create a GUI that will allow users to enter dishes (one or more) of choice (think of a
UI similar to McDonalds self-order), which will be stored as dish objects in the restaurant’s
collection and then processed. Once the dishes are prepared, the GUI will output the dishes
have been prepared and the table they will be served to.
Marks will be allocated to functionality and usability of the GUI
