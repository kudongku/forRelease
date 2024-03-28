# 빌더 이미지 생성
FROM gradle:7.4-jdk17-alpine as builder
WORKDIR /build

# 그래들 파일이 변경되었을 때만 새롭게 의존 패키지를 다운로드 받게 함.
COPY build.gradle settings.gradle /build/
# '--no-daemon' 플래그를 사용하여 Gradle 데몬을 사용하지 않도록 함. 이는 Docker 내에서 데몬이 올바르게 동작하지 않을 수 있기 때문입니다.
RUN gradle build --no-daemon -x test --parallel --continue > /dev/null 2>&1 || true

# 빌더 이미지에서 애플리케이션 빌드
COPY . /build
RUN gradle build --no-daemon -x test --parallel

# 애플리케이션 빌드 완료 후 새로운 스테이지에서 애플리케이션을 실행하는 이미지 생성
FROM openjdk:17-slim
WORKDIR /app

# 빌더 이미지에서 jar 파일만 복사
COPY --from=builder /build/build/libs/*-SNAPSHOT.jar ./app.jar

EXPOSE 8080

# root 대신 nobody 권한으로 실행
USER nobody
ENTRYPOINT [                                                \
    "java",                                                 \
    "-jar",                                                 \
    "-Djava.security.egd=file:/dev/./urandom",              \
    "-Dsun.net.inetaddr.ttl=0",                             \
    "app.jar"                                               \
]