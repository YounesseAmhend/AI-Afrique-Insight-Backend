# Build and Run
.PHONY: run
run:
	mvn spring-boot:run

# Clean build
.PHONY: clean
clean:
	mvn clean

# Clean and run
.PHONY: fresh
fresh: clean run

# Package the application
.PHONY: package
package:
	mvn package

# Run tests
.PHONY: test
test:
	mvn test

# Git operations
.PHONY: git
git:
	git add .
	git commit -m "$(m)"
	git push

# Git operations with pull first (safer)
.PHONY: git-safe
git-safe:
	git pull
	git add .
	git commit -m "$(m)"
	git push

# Show git status
.PHONY: status
status:
	git status

# Show recent changes
.PHONY: changes
changes:
	git log -p -2

# Install dependencies
.PHONY: install
install:
	mvn install

# Run with custom profile (usage: make run-profile PROFILE=dev)
.PHONY: run-profile
run-profile:
	mvn spring-boot:run -Dspring-boot.run.profiles=$(PROFILE)

# Dependency tree
.PHONY: deps
deps:
	mvn dependency:tree

# Check for dependency updates
.PHONY: updates
updates:
	mvn versions:display-dependency-updates

# Help command
.PHONY: help
help:
	@echo "Available commands:"
	@echo "  run         - Run the application"
	@echo "  clean       - Clean the project"
	@echo "  fresh       - Clean and run the application"
	@echo "  package     - Package the application"
	@echo "  test        - Run tests"
	@echo "  git m=\"msg\" - Git add, commit with message, and push"
	@echo "  git-safe    - Git pull, add, commit with message, and push"
	@echo "  status      - Show git status"
	@echo "  changes     - Show recent changes"
	@echo "  install     - Install dependencies"
	@echo "  run-profile - Run with specific profile (PROFILE=name)"
	@echo "  deps        - Show dependency tree"
	@echo "  updates     - Check for dependency updates"
	@echo "  help        - Show this help message"