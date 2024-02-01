pipeline {
environment {
BUILD_NUMBER = "${env.BUILD_NUMBER}"
}
  agent {
    kubernetes {
      yaml '''
        apiVersion: v1
        kind: Pod
        spec:
          containers:
          - name: maven
            image: maven:3.9.4-amazoncorretto-20
            command:
            - cat
            tty: true
          - name: node
            image: node:16-alpine3.12
            command:
            - cat
            tty: true
        '''
    }
  }
  stages {
    stage('Run maven') {
      steps {
        container('maven') {
          sh 'mvn -version'
          echo "Running ${env.BUILD_ID} on ${env.JENKINS_URL}"
          sh 'mkdir -p /root/.m2  && mkdir /root/.m2/repository'
          sh 'cp -i settings.xml /root/.m2'
          sh 'mvn clean deploy -DskipTests  -Dbuild.version=0.0.$BUILD_ID-SNAPSHOT -ntp'
        }
        container('node') {
          sh 'npm version'
          sh 'cat hello.txt'
          sh 'ls -last'
        }
      }
    }
  }
}