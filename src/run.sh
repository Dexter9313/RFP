#!/bin/bash
java -cp "java/bin/:java/lib/poi-3.15/*:java/lib/apache-jena-3.2.0/lib/*:java/lib/poi-3.15/ooxml-lib/*:java/lib/poi-3.15/lib/*:java/lib/mysql-connector-java-5.1.42/*" rfp.ResourceToOnto "--db" "java/temp/DB.txt"
