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
        }
        post {
            always {
                echo "post of api test"
            }
        }
    }
}
