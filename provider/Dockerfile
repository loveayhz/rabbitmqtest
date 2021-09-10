FROM java:8
MAINTAINER ayuehunzi
#WORKDIR d/WorkSpace/java/rabbitmqtest/provider
VOLUME /tmp
ADD ./target/provider-0.0.1-SNAPSHOT.jar app.jar
RUN bash -c 'touch app.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
#暴露8088端口,这个端口对应的是服务本身的端口
EXPOSE 8082