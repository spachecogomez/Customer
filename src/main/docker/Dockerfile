FROM ubuntu:latest
RUN apt-get update -y
RUN apt-get install -y default-jre
COPY customer.jar /home/
WORKDIR /home/
ENTRYPOINT java -jar customer.jar
EXPOSE 8080
