#
# Build a stage
#
FROM maven:3.6.0-jdk-11-slim AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package -DskipTests

#
# Package the stage
#
FROM openjdk:11-jre-slim
COPY --from=build /home/app/target/devops-first-prj-0.0.1-SNAPSHOT.jar /usr/local/lib/devops-first-prj.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/usr/local/lib/devops-first-prj.jar"]
