pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/your-username/your-backend-repo.git'
            }
        }

        stage('Build & Run with Docker Compose') {
            steps {
                sh 'docker-compose down || true'
                sh 'docker-compose -f docker-compose.yml up -d --build'
            }
        }

        stage('Verify Backend') {
            steps {
                // simple health check on port 8081
                sh 'sleep 10'
                sh 'curl -f http://localhost:8081/login || echo "Backend not responding"'
            }
        }
    }

    post {
        always {
            sh 'docker-compose down'
        }
    }
}
