#!/usr/bin/env bash

DIR=$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )
docker pull mongo
docker run -d -p 27017:27017 mongo