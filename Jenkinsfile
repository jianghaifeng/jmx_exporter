def deploymentApproval(String environment, List<String> approvers, String inputQuestion) {
    return input(
        id: "userInput${environment}",
        message: "Deploy to ${environment}",
        parameters: [string(defaultValue: '', description: "Enter 'yes' to deploy to ${environment}", name: "${inputQuestion}")],
        submitterParameter: 'submitter',
        submitter: approvers.join(',')
    )
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
        stage('Deploy?') {
            agent none
            steps {
                script {
                    def shouldDeployToUat = deploymentApproval('UAT', "alice,bob", "shouldWeDeployToUat")
                    def shouldDeployToUat1 = false
                    //env.shouldDeployToUat = shouldDeployToUat.shouldWeDeployToUat
                    echo "${shouldDeployToUat}"
                }
            }
        }
        stage('Deploy') {
            agent none
            stages {
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
                stage ('deploy sub 2 - apitest') {
                    when {
                        equals expected: 'yes', actual: "${Proceed}"
                    }
                    input {
                        message "Should we continue?"
                        submitter "alice,bob"
                        parameters {
                            string(name: "Proceed", defaultValue: '', description: "Enter 'yes' to deploy to start")
                        }
                    }
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