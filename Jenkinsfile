pipeline {
    agent any

    environment {
        IMAGE_NAME     = "randomapp"
        IMAGE_TAG      = "${BUILD_NUMBER}"
        CONTAINER_NAME = "randomapp-container"
    }

    stages {

        stage('Checkout SCM') {
            steps {
                checkout scm
            }
        }

        stage('Run Tests') {
            agent {
                docker {
                    image 'maven:3.9.6-eclipse-temurin-17'
                    args  '-v $HOME/.m2:/root/.m2'
                }
            }
            environment {
                SPRING_PROFILES_ACTIVE = 'docker'
            }
            steps {
                sh 'mvn -B clean test'
            }
        }

        stage('Build Docker Image') {
            steps {
                sh 'docker build -t ${IMAGE_NAME}:${IMAGE_TAG} .'
            }
        }

        stage('Stop Old Container') {
            steps {
                sh '''
                docker stop ${CONTAINER_NAME} || true
                docker rm ${CONTAINER_NAME} || true
                '''
            }
        }

        stage('Run New Container') {
            steps {
                sh '''
                docker run -d \
                  --name ${CONTAINER_NAME} \
                  -e SPRING_PROFILES_ACTIVE=docker \
                  -p 8090:8080 \
                  --restart unless-stopped \
                  ${IMAGE_NAME}:${IMAGE_TAG}
                '''
            }
        }

        stage('Cleanup Images') {
            steps {
                sh 'docker image prune -f'
            }
        }
    }

    post {
        success {
            echo '✅ Tests passed, application deployed'
        }
        failure {
            echo '❌ Pipeline failed — deployment skipped!'
        }
    }
}