FROM openjdk:8-jdk-alpine
VOLUME /tmp
EXPOSE 8085
ARG DEPENDENCY=target/dependency
COPY ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY ${DEPENDENCY}/META-INF /app/META-INF
COPY ${DEPENDENCY}/BOOT-INF/classes /app
ENTRYPOINT ["java","-cp","app:app/lib/*","net.devk.marketing.service.MarketingServiceApplication"]