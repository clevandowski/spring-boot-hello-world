FROM openjdk:8-jdk as builder

ARG MAVEN_VERSION=3.5.2

ADD http://apache.crihan.fr/dist/maven/maven-3/${MAVEN_VERSION}/binaries/apache-maven-${MAVEN_VERSION}-bin.tar.gz /var/lib/

RUN \
  cd /var/lib \
  && tar xvf apache-maven-${MAVEN_VERSION}-bin.tar.gz \
  && ln -s /var/lib/apache-maven-${MAVEN_VERSION}/bin/mvn /usr/bin/mvn \
  && rm -rf /var/lib/apache-maven-${MAVEN_VERSION}-bin.tar.gz

ADD . /source
WORKDIR /source
RUN mvn -e clean package && ls -l /source/target

FROM openjdk:8-jre
RUN mkdir /application
COPY --from=builder /source/target/spring-boot-hello-world-0.0.3-SNAPSHOT.jar /application
WORKDIR /application

CMD [ "bash", "-c", "java -jar spring-boot-hello-world-0.0.3-SNAPSHOT.jar" ]
