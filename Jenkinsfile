#!/usr/bin/env groovy

pipeline {
    options {
        buildDiscarder(logRotator(numToKeepStr: '10'))
    }
    agent any
    stages {
        stage('Clean') {
            steps {
                echo 'Cleaning Project'
                sh 'chmod +x gradlew'
                sh './gradlew clean --no-daemon'
            }
        }
        stage('Build Release') {
            when {
                tag 'release-*'
            }
            environment {
                RELEASE_MODE = '1'
            }
            steps {
                sh './gradlew build --no-daemon'
            }
        }
        stage('Build Snapshot') {
            when {
                not {
                    tag 'release-*'
                }
            }
            steps {
                sh './gradlew build --no-daemon'
            }
        }
    }
    post {
        always {
            archiveArtifacts 'build/libs/**.jar'
        }
    }
}
