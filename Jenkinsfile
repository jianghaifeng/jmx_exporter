pipeline {
    agent none
    stages {
        stage('Build') {
            agent any
            steps {
                echo "step 1 in build"
                echo "step 2 in build"
            }
            post {
                always {
                    echo "post always in build"
                }
            }
        }
        stage('Deploy') {
            agent none
            stages {
                stage ('deploy sub 1') {
                    agent any
                    stages {
                        stage ('deploy sub1 sub1') {
                            steps {
                                echo "step 1 in deploy"
                            }
                        }
                        stage ('deploy sub1 sub2') {
                            steps {
                                echo "step 2 in deploy"
                            }
                        }
                    }
                }
                stage ('deploy sub 2') {
                    agent any
                    steps {
                        echo "step 2 in deploy"
                    }
                }
            }
        }
    }
    post {
        always {
            echo "post in pipeline"
        }
    }
}