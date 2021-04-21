#!/bin/sh
cd console/ || exit
javac -sourcepath ./src/ -d build/classes/ -cp ./libs/jsoup-1.13.1.jar:./libs/commons-lang3-3.11.jar src/ua/com/nkrasnovoronka/unit1/data/User.java src/ua/com/nkrasnovoronka/unit1/jsoup/PageParser.java src/ua/com/nkrasnovoronka/unit1/commons/SystemInformationPrinter.java src/ua/com/nkrasnovoronka/unit1/Main.java

java -cp build/classes/:./libs/jsoup-1.13.1.jar:./libs/commons-lang3-3.11.jar:. ua.com.nkrasnovoronka.unit1.Main