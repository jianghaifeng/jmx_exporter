
pipeline {
    agent any
    stages 
    {
        stage('Start') {
            steps {
                sh 'ls'
            }
        }

        stage('End') {
            steps {
                sh 'ls'
            }
        }
    }
}
