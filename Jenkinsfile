def var = 1

pipeline {
    agent none
    stages {
        stage ('stage1') {
            agent { label 'gradle'}
            steps {
                script {
                    echo "var = ${var}"
                    echo "env.var = ${env.var}"
                    var = 3
                    env.var = var
                    echo "var = ${var}"
                    echo "env.var = ${env.var}"
                }
            }
        }
        stage ('stage2') {
            agent { label 'gradle'}
            steps {
                script {
                    echo "hello"
                    echo "var = ${var}"
                    echo "env.var = ${env.var}"
                }
            }
        }
    }
}
