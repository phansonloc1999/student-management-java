all:
	javac MyProgram.java
	java MyProgram

clean:
	find . -name "*.class" -delete