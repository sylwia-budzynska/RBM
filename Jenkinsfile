pipeline {
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

    stage('Collect Fingerprints') {
      steps {
        fingerprint 'rbm-1.16.4-*.jar'
        fingerprint 'build/libs/rbm-1.16.4*.jar'
      }
    }

  }
  post {
    always {
      archiveArtifacts 'build/libs/**.jar'
    }

  }
  options {
    buildDiscarder(logRotator(numToKeepStr: '10'))
  }
}
