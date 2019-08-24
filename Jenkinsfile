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
            stages {
                stage('sub stage1 in deploy') {
                    steps {
                        echo "step 1 in deploy"
                    }
                }
                stage('sub stage2 in deploy') {
                    steps {
                        echo "step 2 in deploy"
                    }
                }
            }
        }
    }
}