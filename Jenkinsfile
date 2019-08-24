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
            agent none
            stages {
                stage ('deploy sub 1') {
                    agent any
                    steps {
                        echo "step 1 in deploy"
                    }
                }
                stage ('deploy sub 2') {
                    agent any
                    steps {
                        echo "step 2 in deploy"
                    }
                }
            }
            steps {
                echo "step 1 in deploy"
                echo "step 2 in deploy"
            }
        }
    }
}