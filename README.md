# FizzBuzz
Implementation of variation on the well known http://codingdojo.org/kata/FizzBuzz/ kata exercise.

## Step 1

Write code that produces the following output for each number in a contiguous range of integers:

1. the number itself
2. ‘fizz’ for numbers that are multiples of 3
3. ‘buzz’ for numbers that are multiples of 5
4. ‘fizzbuzz’ for numbers that are multiples of 15

Being careful to avoid trailing spaces.
e.g. running the program with a range from 1-20 should produce the following result:
```
1 2 fizz 4 buzz fizz 7 8 fizz buzz 11 fizz 13 14 fizzbuzz 16 17 fizz 19 buzz
```

Init a local git repository and create a commit with the solution.

## Step 2

Please enhance your existing FizzBuzz solution to perform the following:

If the number contains a three you must output the text ‘three’, any other rule is skipped.
e.g. running the program with a range from 1-20 should produce the following result:
```
1 2 three 4 buzz fizz 7 8 fizz buzz 11 fizz three 14 fizzbuzz 16 17 fizz 19 buzz
```

Create a branch for the "three" variation and then a commit with the solution.

## Build
```
mvn clean install
```
## Run application from command line
```
java -jar target/fizzbuzz-1.0-SNAPSHOT-jar-with-dependencies.jar begin end

Example:
java -jar target/fizzbuzz-1.0-SNAPSHOT-jar-with-dependencies.jar 1 20
```

## Run unit tests
```
mvn test
```
