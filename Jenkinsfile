pipeline {
    agent none
    stages {
        stage('Build') {
            agent {label 'agent for build'}
            steps {
                echo "step 1 in build"
                echo "step 2 in build"
            }
        }
        stage('Deploy') {
            agent {label 'agent for deploy'}
            stages {
                stage('sub stage1 in deploy') {
                    echo "step 1 in deploy"
                }
                stage('sub stage2 in deploy') {
                    echo "step 2 in deploy"
                }
            }
        }
    }
}