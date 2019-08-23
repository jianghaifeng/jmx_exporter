pipeline {
    agent none
    stages {
        stage('stage1') {
            agent any
            steps {
                sh "step1"
                sh "step2"
            }
            steps {
                sh "step3"
                sh "step4"
            }
        }
    }
}