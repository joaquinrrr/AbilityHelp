FROM amazoncorretto:17-alpine-jdk
MAINTAINER ESMERALDA
COPY target/abilityhelpv1-0.0.1-SNAPSHOT.jar AbilityHelp.jar
ENTRYPOINT ["java","-jar","/AbilityHelp.jar"]