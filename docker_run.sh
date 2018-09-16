#!/usr/bin/env bash
set -x
set -e

./mvnw clean install
./mvnw package
docker build --tag=magicnumber-image --rm=true .
docker run -p 8080:8080 -t magicnumber-image