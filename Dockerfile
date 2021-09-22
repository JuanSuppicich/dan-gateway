FROM openjdk:11.0.7-slim
ARG JAR_FILE
ADD target/${JAR_FILE} dan-gateway.jar
RUN echo ${JAR_FILE}
ENTRYPOINT ["java","-jar","/dan-gateway.jar"]