def aptTest(){
    return {
        echo 'aptTest'
    }
}

def func(){
    return {
        stage('clone'){        
            checkout([$class: 'GitSCM', commitId: 'cae9f2'])
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
            }         
            agent any
            steps{
                script{
                    echo "${scm.GIT_COMMIT}"
                    echo "${env.GIT_COMMIT}"
                    sh 'pwd'
                    sh 'ls -la'
                    func().call()
                    echo 'custom'
                }
            }
        }
        stage('API Test'){
            options{
                skipDefaultCheckout()
            }
            agent any
            steps{
                script{
                    echo "${scm.GIT_COMMIT}"
                    echo "${env.GIT_COMMIT}"
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
