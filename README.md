# spring-boot-kafka
This application has kafka in a docker container provided by confluent configured in docker-compose file.

https://docs.confluent.io/current/quickstart/ce-docker-quickstart.html


There are two Docker files one with UI and one with just kafka without UI. 

You can start spring boot application directly using gradle task under application -> bootRun which will first start 
the containers defined in the docker-compose.yml file and then start the application.

You can independently start the docker containers using the gradle task under dockers services -> Start Services

After following above steps you can access the Kafka UI on localhost:9021

The spring boot application has both producer and consumer defined in the same project in service package in their 
respective files.

Upon starting the producer starts sending messages automatically to kafka through a spring boot scheduler. There is a 
separate controller defined which you can use to send events yourself through curl or postman.

The consumer is listening for the messages and receives them kafka server.

The  configuration for kafka producer and consumer are defined under resources/application.properties file


