Steps to launch:-

1. Download the code
2. Import the code in Eclipse as existing maven project
3. Go to /BlueStacks/src/main/java/Runner/TestRunner.java
4. Make changes to the features tag for your path where Feature is downloaded and Save
5. Go to /BlueStacks/src/main/java/Executors/TestExecutors.java
6. Change the path of chromedriver in the function launchBrowserandGoToHomePage(String). ChromeDriver is in the Library BlueStacks\Library
7. Right Click on the TestRunner.java and RunAs Junit Test
8. If you face problems related to dependencies, right click on pom.xml, run as maven clean or maven build-> clean install
9. OutPut will be in /BlueStacks/target/output.txt


There is already an output of all the games in the target folder. Please have a look. 
Thanks! :)