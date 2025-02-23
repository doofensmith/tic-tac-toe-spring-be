#import base JDK from Linux
FROM eclipse-temurin:21-jre-jammy

#work directory
WORKDIR /app

# copy application file
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} /app/app.jar

# expose port
EXPOSE 5501

#env var
#ENV JAVA_OPTS=""

# run application
ENTRYPOINT ["java","-jar","/app/app.jar"]