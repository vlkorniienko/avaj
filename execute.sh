find . -name "*.java" > sources.txt
javac -sourcepath . @sources.txt
java avaj.aircrafts.Avaj