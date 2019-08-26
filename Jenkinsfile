def approv = [
    'alice',
    'bob'
]
pipeline {
    agent none
    stages {
        stage('Build') {
            agent any
            steps {
                echo "${GIT_COMMIT}"
                echo "env.gitCommit = ${env.gitCommit}"
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
                    def shouldDeployToUat = input (
                        message: "Deploy to uat",
                        parameters: [string(defaultValue: '', description: "Enter 'yes' to deploy to uat", name: "dep")],
                        submitter: "alice,bob"
                    )
                    echo "${GIT_COMMIT}"
                    env.gitCommit = GIT_COMMIT
                    env.deployOK = shouldDeployToUat
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
                                echo "env.gitCommit = ${env.gitCommit}"
                                checkout([$class: 'GitSCM', branches: [[name: "${env.gitCommit}"]]])
                                echo "env.deploy = ${env.deployOk}"
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
                        beforeInput false
                        equals expected: 'yes', actual: Proceed
                        equals expected: 'yes', actual: env.deployOK
                    }
                    input {
                        message "Should we continue?"
                        submitter approv.join(',')
                        parameters {
                            string(name: "Proceed", defaultValue: '', description: "Enter 'yes' to deploy to start")
                        }
                    }
                    agent any
                    steps {
                        script {
                            def hf = Proceed
                            echo "${hf}"
                        }

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