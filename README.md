# Bundle Calculator

## Context
Social media influencers have been basing the price of their social media post on a single post basis. So if a brand required 10 posts (for example spread over a period) then they would be charged 10x the cost of a single post. One company has decided to allow social media influencers to sell posts in bundles and charge the brand on a per bundle basis. So if the Influencer sold image based posts in bundles of 5 and 10 and brand ordered 15 they would get a bundle of 10 and a bundle of 5.

The company currently allows the influencer to monitize the following submission formats:

Submission format | Format code | Bundles
----------------- | ----------- | -------
Image | IMG | 5 @ $450 10 @ $800
Audio | Flac | 3 @ $427.50 6 @ $810 9 @ $1147.50
Video | VID | 3 @ $570 5 @ $900 9 @ $1530

## Task

Given a brands order, you are required to determine the cost and bundle breakdown for each submission format. For simplicity, each order should contain the minimal number of bundles.

### Input:
Each order has a series of lines with each line containing the number of items followed by the submission format code
An example input:
```
10 IMG
15 FLAC
13 VID
```

### Output:
A successfully passing test(s) that demonstrates the following output: (The format of the output is not important)
```
10 IMG $800
  1 x 10 $800
15 FLAC $1957.50
  1 x 9 $1147.50
  1 x 6 $810
13 VID $2370
  2 x 5 $1800
  1 x 3 $570
```

## Task Requirement:  
1. Using Java 
2. Object-oriented programming (OOP)
3. Using gradle   
4. Using Java 8 Stream 
5. Using Java Lambda if you can   
6. Using Lombok   
7. Using Java Logging instead of system.out.println   
8. Adding some unit tests (JUnit 5)
9. Considering to Separation of concerns（SoC）

## Design Concept

main
```
|-- java
        |-- Bundles
        |-- BundlesCharge
        |-- Calculator
        |-- FormatCode
        |-- Main
        |-- OrderItem
        |-- PrintResult
|-- resources
      |-- config.properties

test
|-- java
      |-- BundlesTest
      |-- CalculatorTest
      |-- MainFunctionTest
      |-- PrintResultTest
```

Main.java is the starting point of the program, being responsible for inputting and outputting.

Calculator.java is the class to return BundlesCharge which includes bundlesCharge and totalCost.

config.properties store the configurable parameters for different types of bundles.

OrderItem.java is the order for a specific type of bundle.

FormatCode.java is the enumeration of format code.

BundlesCharge.java  has an array of the number of bundles and the total cost.

Bundles.java are different types of bundles.

Bundles.java is to print out the result.

BundlesTest.java are the JUnit 5 tests for Bundles.java.

CalculatorTest.java are the JUnit 5 tests for Calculator.java.

MainFunctionTest.java are the JUnit 5 tests for Main.java.

PrintResultTest.java are the JUnit 5 tests for PrintResult.java.

## Run the program
Run the program by running Main.java 

The program also can convert the lower case format code to upper case.
If '2 IMG' and '5 IMG' are input, the program can add them together as '7 IMG'
When the input is not valid, return the warning.

You can input: 
```
10 IMG
15 FLAC
end
```

The output:
```
15 IMG $1250.0
     1 x 10 $800.0 
     1 x 5 $450.0 

100 FLAC $13050.0
     11 x 9 $12622.5 
     1 x 3 $427.5
```

Run BundleCalculationTest.java to test the program.

