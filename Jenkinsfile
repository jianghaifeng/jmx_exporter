def needApprove() {
    return {
        when {
            beforeInput false
            equals expected: 'yes', actual: "${Proceed}"
        }
        input {
            message "Should we continue?"
            ok "Yes, we should."
            submitter "alice, bob"
            parameters {
                string(name: "Proceed", defaultValue: '', description: "Enter 'yes' to deploy to start")
            }
        }
    }
}

def deployStage() {
    return {
        stage ('deploy sub 1') {
            options{
                skipDefaultCheckout()
            }
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
    }
}

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
                    steps {
                        script {
                            deployStage()
                        }
                    }
                }
                stage ('deploy sub 2 - apitest') {
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