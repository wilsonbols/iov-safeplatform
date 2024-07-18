# Use a base image with Maven and OpenJDK
FROM swr.cn-north-4.myhuaweicloud.com/iov-workshop/sccompilebase:latest AS build

# Set the working directory in the container
WORKDIR /app

# Copy the project files into the container
COPY pom.xml .
COPY web ./web

#RUN rm -rf /usr/share/maven/conf/settings.xml
#COPY settings.xml /usr/share/maven/conf/settings.xml

# Build the application
RUN mvn clean package

# Use a lightweight base image for the runtime environment
FROM openjdk:17-jdk-slim-bullseye

# Set the working directory in the container
WORKDIR /app

# Copy the JAR file from the build stage to the runtime image
COPY --from=build /app/web/target ./target

# Expose the port your application runs on
EXPOSE 8090

# Define the command to run your application
CMD ["java", "-jar", "target/safeplatform-1.0-SNAPSHOT.jar"]