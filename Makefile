# Build and run the application
main: 
	mvn clean package
	mvn spring-boot:run

# Git operations with commit message
git:
	git add .
	git commit -m "$m"
	git push

# Run tests
test:
	mvn test

# Clean build artifacts
clean:
	mvn clean

# Run static code analysis
lint:
	mvn checkstyle:check

# Run with debug mode
debug:
	mvn spring-boot:run -Dspring-boot.run.jvmArguments="-Xdebug -Xrunjdwp:transport=dt_socket,server=y,suspend=y,address=5005"

# Generate code coverage report
coverage:
	mvn jacoco:report