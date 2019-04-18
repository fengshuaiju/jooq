# jooq jpa entity generate

cd ./entities
run mvn install
cd ..
cd ./jpa
run mvn jooq-codegen:generate
run mvn spring-boot:run


curl 127.0.0.1:8080/jooq/books