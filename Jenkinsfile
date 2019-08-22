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
            checkout([$class: 'GitSCM', branches: [[name: 'cae9f262557f4460a3de920fa9542f8ed75f5cbe' ]]])
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
                    aptTest().call()
                    stage('post hook'){
                        echo 'custom'
                    }
                }
            }
        }
    }
}
