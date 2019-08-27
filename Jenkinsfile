def approv = [
    'alice',
    'bob'
]

def var = 1


def func() {
    return {
        stage('test stage 1') {
            echo 'test stage 1'
        }
        stage('test stage 2') {
            echo 'test stage 2'
        }
    }
}

pipeline {
    agent none
    parameters {
        string(name: 'PERSON', defaultValue: 'Mr Jenkins', description: 'Who should I say hello to?')
    }
    stages {
        stage('Build') {
            agent any
            steps {
                echo "GIT_COMMIT = ${GIT_COMMIT}"
                echo "env.GIT_COMMIT = ${env.GIT_COMMIT}"
                echo "env.gitCommit = ${env.gitCommit}"
                echo "step 1 in build"
                echo "step 2 in build"
                echo "var = ${var}"
                echo "env.var = ${env.var}"
                echo "PERSON = ${params.PERSON}"

                script {
                    var = 2
                    env.var = 2
                    env.gitCommit = GIT_COMMIT
                    sh 'cat data'
                }
                echo "var = ${var}"
                echo "env.var = ${env.var}"
                echo "PERSON = ${params.PERSON}"
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
                    
                    env.deployOK = shouldDeployToUat
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
                                echo "var = ${var}"
                                echo "env.var = ${env.var}"
                                echo "env.gitCommit = ${env.gitCommit}"
                                checkout([$class: 'GitSCM', branches: [[name: "${env.gitCommit}"]]])
                                echo "env.deploy = ${env.deployOk}"
                                echo "step 1 in deploy"
                                echo "PERSON = ${params.PERSON}"
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
                            func().call()
                            func().call()
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