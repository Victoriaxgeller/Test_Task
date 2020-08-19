There are 2 projects in one repository:

1. Api User tests on https://reqres.in/ 

Parallel launch implemented with the help of TestNG


Command for tests launching:

mvn -B -f ./pom.xml clean test -DbuildDirectory=./target -Dsuite=xmls/ApiUserTests.xml


Command for allure-report generating:

mvn io.qameta.allure:allure-maven:serve



report example watch here http://joxi.ru/Vm6MzevtjMD9Wr

-------------------------------------------------------------------------
2. Ui tests on http://automationpractice.com/


Command for tests launching in chrome browser: 

mvn -B -f ./pom.xml clean test -DbuildDirectory=./target -Dsuite=xmls/UiLogoutTests.xml -Dbrowser=chrome  -Dwdm.chromeDriverVersion=84.0.4147.30


Command for tests launching in firefox browser: 

mvn -B -f ./pom.xml clean test -DbuildDirectory=./target -Dsuite=xmls/UiLogoutTests.xml -Dbrowser=firefox



Command for allure-report generating:

mvn io.qameta.allure:allure-maven:serve



Report example http://joxi.ru/4AkJQwvcXzRnD2