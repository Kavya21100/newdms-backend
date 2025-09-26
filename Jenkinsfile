pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git url: 'https://github.com/Kavya21100/newdms-backend.git',
                    branch: 'main',
                    credentialsId: 'github-credentials'
            }
        }

        stage('Build & Run with Docker Compose') {
            steps {
                sh 'docker-compose up -d --build'
            }
        }

        stage('Verify Backend') {
            steps {
                sh 'docker ps'
            }
        }
    }

    post {
        always {
            sh 'docker-compose down || true'
        }
    }
}
