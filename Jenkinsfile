def aptTest(){
    return {
            echo 'aptTest'
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
            input{
                 id 'userInput'
                 message 'Enter path of test reports:?'
                 parameters  [
                 [$class: 'TextParameterDefinition', defaultValue: 'None', description: 'Path of config file', name: 'Config'],
                 [$class: 'TextParameterDefinition', defaultValue: 'None', description: 'Test Info file', name: 'Test']]
            }
            
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
                    echo 'custom'
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
