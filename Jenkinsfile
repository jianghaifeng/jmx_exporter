def aptTest(){
    return {
        stage('aptTest'){
            echo 'aptTest'
        }
    }
}

def func(){
    return {
        stage('clone'){        
            checkout([$class: 'GitSCM', branches: [[name: 'cae9f2' ]]])
        }
    }
}

pipeline {
    agent any
    stages 
    {
        stage('Start') {
            steps {
                sh 'ls'
            }
        }

        stage ('Invoke_pipeline') {
            steps {
                build job: 'pipeline1', parameters: [
                string(name: 'param1', value: "value1")
                ]
            }
        }

        stage('End') {
            steps {
                sh 'ls'
            }
        }
    }
}

pipeline1 {
    agent none
    stages{        
        stage('Deploy'){
            agent any
            steps{
                script{
                    func().call()
                    echo 'custom'
                }
            }
        }
        stage('API Test'){
            agent any
            steps{
                script{
                    aptTest().call()
                    stage('post hook'){
                        echo 'custom'
                    }
                }
            }
            post {
                always {
                    echo "post of api test"
                }
            }
        }
    }
}
