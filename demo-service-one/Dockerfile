FROM maven:3-openjdk-11-slim as builder

WORKDIR /build

# Copy the dependency specifications
COPY pom.xml pom.xml
COPY $dirname/pom.xml $dirname/pom.xml

# Resolve dependencies for the main application
RUN mvn -q -ntp -B -pl $dirname -am dependency:go-offline -Dmaven.test.skip=true
# Copy sources for main application
COPY $dirname $dirname
# Package the common and application modules together
RUN mvn -q -ntp -B -pl $dirname package -Dmaven.test.skip=true

RUN mkdir -p /jar-layers
WORKDIR /jar-layers
# Extract JAR layers
RUN java -Djarmode=layertools -jar /build/$dirname/target/*.jar extract

FROM adoptopenjdk/openjdk11:centos-jre

RUN mkdir -p /app
WORKDIR /app

# Copy JAR layers, layers that change more often should go at the end
COPY --from=builder /jar-layers/dependencies/ ./
COPY --from=builder /jar-layers/spring-boot-loader/ ./
COPY --from=builder /jar-layers/snapshot-dependencies/ ./
COPY --from=builder /jar-layers/application/ ./

ENTRYPOINT ["java", "org.springframework.boot.loader.JarLauncher"]
