# JAR 파일 이름 (버전에 맞게 수정하세요)
FROM eclipse-temurin:17-jdk
ARG JAR_FILE=build/libs/kotlin-mission-0.0.1-SNAPSHOT.jar

# JAR 복사
COPY ${JAR_FILE} app.jar

# 포트 (필요에 따라 수정 가능)
EXPOSE 8080

# 애플리케이션 실행
ENTRYPOINT ["java", "-jar", "/app.jar"]