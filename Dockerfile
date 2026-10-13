# mvn clean package
# mvn clean package -DskipTests

# docker image build -t imageAdi .
# docker container run -d -p 4444:4444 --rm --name blog

# JDK
#FROM openjdk:17
FROM openjdk:21-ea
#FROM eclipse-temurin:21
#FROM eclipse-temurin:21-jre-jammy

# Bilgilendirme
LABEL maintainer="hamitmizrak@gmail.com"

#Çevresel değişkenler
ENV APP_NAME="Full Stack Spring Boot"
ENV VERSION="v1.0.0"
ENV PORT="5555"

# Çevresel Değişkenleri RUN
RUN echo "App Name: $APP_NAME"
RUN echo "Version: $VERSION"
RUN echo "Port: $PORT"

# Kalıcılık
VOLUME /tmp

# Port
EXPOSE 5555

# mvn clean && mvn package
# Proje Jar ismini
ARG JAR_FILE=/target/*.jar

# Proje isimlednirme
ADD ${JAR_FILE} blog_springboot_react

# Uygulama Başlatma Komut dizini
ENTRYPOINT ["java","-jar","/blog_springboot_react"]


# HEALTHCHECK: Sağlık kontrolünü Eklesin
# HEALTHCHECK: Bu container çalışıyor mu ?
HEALTHCHECK --interval=30s --timeout=10s --start-period=5s --retries=3 \
    CMD curl -f http://localhost:5555/ || exit 1






