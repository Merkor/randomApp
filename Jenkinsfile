pipeline {
    agent any

    environment {
        IMAGE_NAME = "randomapp"
        IMAGE_TAG = "${env.BUILD_NUMBER}"
        CONTAINER_NAME = "randomapp-container"
    }

    stages {

        stage('Run Tests') {
            steps {
                sh 'mvn -B clean test'
            }
        }

        stage('Build Docker Image') {
            steps {
                sh '''
                docker build -t ${IMAGE_NAME}:${IMAGE_TAG} .
                '''
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
            echo 'Deployment successful 🚀'
        }
        failure {
            echo 'Build failed ❌ Container not updated'
        }
    }
}