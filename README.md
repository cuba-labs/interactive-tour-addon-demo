# Tour addon demo

This is a small demo for the interactive tour addon.

# UI Tests

The project contains some UI tests performing on the Chrome web browser.
In order to perform UI tests, you should have the latest version of [Chrome WebDriver](http://chromedriver.chromium.org/downloads) depending on your Chrome web browser.

To run the tests, do the following:

- To prepare the environment for the UI tests you need to call following Gradle tasks:

        gradlew prepareTest startDb createDb

- Then you need to start the application:
        
        gradlew start

- Finally run the command below to perform UI tests:

        gradlew testUi -Dselenide.browser=chrome -Dwebdriver.chrome.driver=<path_to_webdriver>
        
  where `<path_to_your_webdriver>` is the path to Chrome WebDriver on your computer. For instance:
  
  - UNIX:
        
        /home/<user_name>/chromedriver
        
  - WINDOWS:
  
        C:\users\<user_name>\chromedriver.exe
