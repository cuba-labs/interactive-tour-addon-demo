# tour-addon-demo

This is a small demo for the interactive tour addon.

# UI Tests

The project contains some UI tests. 

In order to run the tests, do the following:

- to prepare the environment for the tests you need to call in the terminal the Gradle task:

        gradlew prepareTest

- to run the simple test or the test class you need to edit standard
  test configuration for the test project in IntelliJ. To do so, click the
  *Select Run/Debug Configuration* button and select *Edit Configurations*  in the
  drop-down list. In the VM options field, add the following:

      -Dselenide.browser=chrome -Dwebdriver.chrome.driver=<your_path>/chromedriver.exe

  where `<your_path>` is the path to the chrome driver on your computer.

  After that, select the simple test or the test class you want to run, right
  click on it and select *Debug* option.
