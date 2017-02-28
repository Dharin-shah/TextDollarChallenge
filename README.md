# TextDollarChallenge
This is my approach to Text Dollar Challenge, it uses a divide and conquer strategy and also Strategy pattern to divide based on split strategy along with position information encapsulated.


Note :- 
There are few ways to optimize this.
* Use StringBuilder instead of String. (String is immutable so it returns a String everytime I call substring). Also since we are confined to a method and local objects we shouldnt worry about thread safety.
* Cache Split Objects and use them since we are constantly repeating splits.
