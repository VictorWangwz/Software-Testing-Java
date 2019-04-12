# My Analyzer
This file will state in detail the analysis on the result of bug checking using Error Prone targeting the bug described in MyBugs.md.
##  Assignment requirements
After implementing your bug checker, test it on a sample program that has at least three (3) different instances
of the bug, which would trigger your static analysis checker to report a failure/warning message. Also include
a similar sample program that does not contain the bug, on which your checker would pass without any failure/warning reports.
You should also provide proper unit tests for your checker code. Using Maven for building and testing your
code is encouraged.
Create a file called MyAnalyzer.md and describe (1) why you chose the framework you chose, (2) conceptually,
how you use the framework to detect the bug you described above.

## Instances of bugs
Positive Cases which will trigger the checker to report the failure: 1. int A = 0; 2. String PositiveCase; 3. Map<Integer, Integer> HashMapSample.
Negative Cases which will pass the checker: int aSimpleVariable = 0;
After running the test cases of these four, the result is shown in the figure below:

## Reason to choose Error Prone
EError Prone is a static analysis tool for Java that catches common programming mistakes at compile-time.
It is open source and well-documented and available to the source code. 
It is easy to use and can directly use Maven as the build tool. 
And it is powerful with many default bug checkers.
Most importantly, it uses Java which is much familiar to use than other languages.
