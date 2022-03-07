FROM openjdk:11.0.10-jre-slim-1

RUN mkdir -p /app/config
WORKDIR /app

ENV JAVA_OPTS=""

# para fazer debug remoto, adicionar ao JAVA_OPTS o seguinte: -agentlib:jdwp=transport=dt_socket,address=5005,server=y,suspend=n
ENTRYPOINT exec java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app/batch-processing.jar

# diretório onde pode ser incluído application.properties específico sobrescrevendo propriedades default
VOLUME /app/config
# workdir do tomcat
VOLUME /tmp

COPY target/batch-processing.jar .

RUN chown -R app:app /app
USER app
