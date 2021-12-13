FROM arm32v7/openjdk:8-jdk
EXPOSE 8080:8080
RUN mkdir /app
COPY ./build/install/com.example.ktor-sample/ /app/
COPY ./docker-compose.yml /app/docker-compose.yml
WORKDIR /app
CMD ["..bin/com.example.ktor-sample"]