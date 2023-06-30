FROM eclipse-temurin:17.0.6_10-jdk-jammy

WORKDIR /app

COPY ["hermes-api-main/build/libs/hermes-api-main-*.jar", "./hermes-api.jar"]
COPY ["docker/pipeline/entrypoint.sh", "/entrypoint.sh"]

RUN chmod +x /entrypoint.sh

STOPSIGNAL SIGTERM
ENTRYPOINT ["/entrypoint.sh"]