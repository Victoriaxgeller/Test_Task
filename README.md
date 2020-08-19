Command for API tests launching
mvn -B -f ./pom.xml clean test -DbuildDirectory=./target -Dsuite=xmls/UserTests.xml
Tests run in parallel
Command for allure-report generation
mvn io.qameta.allure:allure-maven:serve
report example watch here http://joxi.ru/Vm6MzevtjMD9Wr

-ea -Dbrowser=chrome -Dwdm.chromeDriverVersion=84.0.4147.30  command for launching ui tests


