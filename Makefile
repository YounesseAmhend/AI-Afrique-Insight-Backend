main:
	mvn spring-boot:run

git:
	git add .
	git commit -m "$(m)"
	git push
pull:
	git submodule init
	git submodule update --recursive\


gen-grpc:
	protoc -I=. \
		--java_out=./src/main/java/com/v1/app/grpc \
		$(shell find protos -name "*.proto")  

sub-modules:
	git submodule update --recursive --remote --init


	