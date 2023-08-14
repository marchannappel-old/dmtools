FROM node:20-alpine

MAINTAINER "Marc Hannappel"

WORKDIR /home/app

COPY public /home/app/public
COPY src /home/app/src
COPY package.json /home/app
COPY tsconfig.json /home/app

RUN cd /home/app
RUN npm install

EXPOSE 3000