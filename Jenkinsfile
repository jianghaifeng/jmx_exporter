pipeline {
    agent none
    stages {
        stage('Build') {
            agent any
            steps {
                echo "step 1 in build"
                echo "step 2 in build"
            }
        }
        stage('Deploy') {
            agent any
            steps {
                echo "step 1 in deploy"
                echo "step 2 in deploy"
            }
        }
    }
}