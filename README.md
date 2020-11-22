#Installation of the 'Application'

#### Pre-requisites 
Before you install the application for the first time on a new host machine, you need to ensure that the following software/tools already installed on that on. Afterward, you can proceed with next step.

1. Java 8
2. NodeJS 12.7
3. Docker, Docker-Compose

## 1. Creating 'Build'

First create build using following command.

`sh build.sh`

## 2. Building Docker Image

Create Docker Build using following command. This command is also used for re-building images. 

`docker-compose build`

## 3. Docker Up 

Run the following command and Compose starts and runs your entire application setup.

`docker-compose build`
