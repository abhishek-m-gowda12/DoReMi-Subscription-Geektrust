# DoReMi-Subscription-Geektrust

* Machine Coding Problem Statement:  https://www.geektrust.com/challenge/doremi-subscriptionDetail .

# Pre-requisites
* Java 1.8
* Maven

# How to run the code

We have provided scripts to execute the code.

Use `run.sh` if you are Linux/Unix/macOS Operating systems and `run.bat` if you are on Windows. 
Both the files run the commands silently and prints only output from the input file `sample_input/input1.txt`.
You are supposed to add the input commands in the file from the appropriate problem statement.

Internally both the scripts run the following commands

* `mvn clean install -DskipTests assembly:single -q` - This will create a jar file `geektrust.jar` in the `target` folder.
* `java -jar target/geektrust.jar sample_input/input1.txt` - This will execute the jar file passing in the sample input file as the command line argument

We expect your program to take the location to the text file as parameter. Input needs to be read from a text file, and output should be printed to the console. The text file will contain only commands in the format prescribed by the respective problem.
