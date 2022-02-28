all:
	javac -cp Lib/Helper/mysql-connector-java-8.0.28.jar:. MyProgram.java

clean:
	find . -name "*.class" -delete