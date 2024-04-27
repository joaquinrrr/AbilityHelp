FROM amazoncorretto:17-alpine-jdk
MAINTAINER cramo
COPY target/abilityhelpv1-0.0.1-SNAPSHOT.jar AbilityHelpBackend.jar
ENTRYPOINT ["java","-jar","/AbilityHelpBackend.jar"]