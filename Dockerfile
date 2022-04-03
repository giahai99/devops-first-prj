FROM openjdk:8
ADD target/devops-first-prj-0.0.1-SNAPSHOT.jar devops-first-prj-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","devops-first-prj-0.0.1-SNAPSHOT.jar"]