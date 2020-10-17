#!/bin/bash

# Install Jabba
curl -sL https://github.com/shyiko/jabba/raw/master/install.sh | bash && . ~/.jabba/jabba.sh

# Install Java
jabba install adopt@1.13.0-2

# Set default java runtime
jabba use adopt@1.13.0-2

# Update gradle if required
./gradlew wrapper

echo "Making sure smoke test passes and we can build a runnable jar ..."

./gradlew clean check distTar


if [[ "{{cookiecutter.version_control}}" == "git" ]]; then
    echo "Initializing git repo"
    if [[ -z "$GIT" ]]; then
        GIT="$(which git)"
    fi

    if [[ ! -z "$GIT" && -x "$GIT" ]]; then
        echo "We are in the $(pwd) folder - git is $GIT"
        "$GIT" init --quiet
        "$GIT" add .
        "$GIT" remote -v
        "$GIT" commit --quiet -a -m "Initial import"
        "$GIT" remote add origin "{{cookiecutter.version_control_remote_origin}}"
        "$GIT" pull --quiet --rebase origin master
        "$GIT" push --quiet origin master
    else
        echo "WARNING: git requested, but git binary not found" >&2
    fi
fi

