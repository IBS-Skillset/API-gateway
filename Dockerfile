FROM public.ecr.aws/amazoncorretto/amazoncorretto:11

WORKDIR /opt/app

COPY target/api-gateway.jar /opt/app/api-gateway.jar

ENTRYPOINT ["/usr/bin/java"]
CMD ["-Dorg.apache.catalina.STRICT_SERVLET_COMPLIANCE=true", "-jar", "/opt/app/api-gateway.jar"]

EXPOSE 9192
