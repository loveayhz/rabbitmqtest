FROM java:8
#WORKDIR d/WorkSpace/java/rabbitmqtest/consumer
MAINTAINER ayuehunzi
VOLUME /tmp
ADD ./target/consumer-0.0.1-SNAPSHOT.jar app.jar
RUN bash -c 'touch /app.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
#暴露8088端口,这个端口对应的是服务本身的端口
EXPOSE 8081