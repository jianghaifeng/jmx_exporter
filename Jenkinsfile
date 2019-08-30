def var = 1

pipeline {
    agent none
    stages {
        stage ('stage1') {
            agent any
            steps {
                script {
                    echo "var = ${var}"
                    echo "env.var = ${env.var}"
                    var = 7
                    env.var = var
                    echo "var = ${var}"
                    echo "env.var = ${env.var}"
                }
            }
        }
        stage ('stage2') {
            agent any
            steps {
                script {
                    echo "var = ${var}"
                    echo "env.var = ${env.var}"
                }
            }
        }
    }
}
