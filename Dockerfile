FROM openjdk:16-jdk-slim
ADD todo_springboot.iml
ARG JVM_OPTS
ENV JVM_OPTS=${JVM_OPTS}

CMD java ${JVM_OPTS} -jar app.jar
ENTRYPOINT ["java" ,"TodoSpringbootAppApplication" ]