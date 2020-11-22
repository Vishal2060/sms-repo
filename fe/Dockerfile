FROM node:12.7-alpine AS build
WORKDIR /usr/src/app
COPY dist/fe /usr/src/app
RUN npm install -g http-server
ENTRYPOINT ["http-server","-p","4200","-g","-o","/usr/src/app"]
