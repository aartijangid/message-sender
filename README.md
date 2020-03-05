**Crossengage Coding Challenge:** 

We would like you to solve the following coding challenge. Please do so while adhering to the **restrictions** given! 
We expect that it takes you a couple of hours to complete the task. Then take some time and write down 
points that you would improve on if given more time. 

**Restrictions**:

- use plain java (no additional libraries in pom) 
OR implement the challenge in flink, writing email addresses and phone numbers to kafka queues using kafka connector
- add tests for your code
- do not publish the solution on GitHub, but send it to us as a zip file; the file name must contain your name

**Challenge**:

You are given a piece of code that imports a list of users and sends them an email. 
For this challenge do not implement the necessary code to actually send any message, just write messages to the console.

Please extend, refactor and change the code to **improve** it and add the following features:
1. Only enabled users receive messages
2. It is possible to send sms messages (`contactBy` is `phone`)
3. It is possible to send both email and sms at once (`contactBy` is `all`)

**Assume**:

- file may contain millions of accounts
- not all accounts are valid

**Implementation Details**:
- Design Pattern implemented is Command Design Pattern

**Initial Thoughts**:
- Can be implement using jOOL or Guava, Google Library

**To Do**:
- Handle edge cases e.g. invalid data file, invalid email address 
- Extend the solution to implement Factory Pattern
