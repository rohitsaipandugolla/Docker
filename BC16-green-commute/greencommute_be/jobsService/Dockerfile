FROM  adoptopenjdk/openjdk11
COPY ./build/libs/jobsService-*.jar app.jar
EXPOSE 8081
ENTRYPOINT ["java","-jar","app.jar"] 