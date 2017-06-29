# Version 0.0.1
FROM java:8

MAINTAINER William Sun "1120_sungang@gmail.com"

# 环境变量
ENV WORK_PATH /home/project/docker-example
ENV APP_NAME @project.build.finalName@.@project.packaging@
ENV APP_VERSION @project.version@


#RUN rm -vf /var/lib/apt/lists/*
#RUN apt-get update
#RUN apt-get install -y nginx

EXPOSE 8080

#USER
#USER user:group

#VOLUME
#VOLUME ["/home/project", "/tmp/data"]

#ADD
ADD $APP_NAME $WORK_PATH/

#COPY
COPY . $WORK_PATH/

#LABEL
#STOPSIGNAL
#ARG
#ONBUILD

# WORKDIR
WORKDIR $WORK_PATH

# ENTRYPOINT
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom"]

# CMD
CMD ["-jar", "@project.build.finalName@.@project.packaging@"]

