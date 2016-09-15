#!/usr/bin/env bash

cd resource-app-repo
mvn package
mv target/reaction-app.jar ../output/reaction-app.jar