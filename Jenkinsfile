pipeline {
    agent none
    stages {
        stage('Build') {
            agent any
            steps {
                sh "step 1 in build"
                sh "step 2 in build"
            }
        }
        stage('Deploy') {
            agent any
            steps {
                sh "step 1 in deploy"
                sh "step 2 in deploy"
            }
        }
    }
}