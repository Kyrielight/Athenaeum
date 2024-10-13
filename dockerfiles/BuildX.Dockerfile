# This file should be referenced from the project root directory.

FROM --platform=linux/${TARGETARCH} amazoncorretto:11 as release

WORKDIR /athenaeum
COPY ./bazel-bin/moe/best/athenaeum/app/usagi_deploy.jar ./usagi.jar

ENTRYPOINT ["java", "-jar", "usagi.jar"]