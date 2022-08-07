1.- To execute this framework you only need to go to this route: src/test/java/tests/runners/
2.- There you will find a Java Class name Runner.
3.- You can just right click it and it will execute all the test cases.
4.- You can find all the test cases on the folliwing package route: src/test/java/tests/features/
5.- Every Feautre is a test case for example if you enter to the Alerts.feature you would se a Tag on the top of the file
6.- Tag = @Alerts
7.- For example if you want to execute only the Alerts test case you can go to the Runner class that we find on the step 2 of this README.
8.- Once you open the class there would be a commented line like this //tags= "@Alerts", 
9.- If you ucoment that line and press the run button it will only execute the Alerts test case.
10.- To create an HTML report with all the test cases statuses you would need to copy the following route of the allure-results: C:\Stori-QA-Automation-Challenge\allure-results
11.- Then you will execute this on the command line: Allure serve C:\Stori-QA-Automation-Challenge\allure-results
12.- Then should be displayed a Web Page with all the tests executions