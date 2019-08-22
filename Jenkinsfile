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
        stage('func1'){
            echo 'from function1'
        }
        stage('func2'){
            echo 'from function2'
        }
        stage('func3'){
            echo 'from function3'
        }
        stage('func4'){
            echo 'from function4'
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
    }
}
