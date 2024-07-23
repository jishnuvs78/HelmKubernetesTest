FROM openjdk:17
VOLUME /tmp
EXPOSE 8080
ADD target/HelmKubernetesTest-0.0.1-SNAPSHOT.jar HelmKubernetesTest-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/HelmKubernetesTest-0.0.1-SNAPSHOT.jar"]