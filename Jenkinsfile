def var = 1

pipeline {
    agent none
    stages {
        stage ('stage1') {
            agent any
            steps {
                script {
                    echo "${GIT_COMMIT}"
                    echo "var = ${var}"
                    echo "env.var = ${env.var}"
                    var = 2
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
                    echo "${GIT_COMMIT}"
                    echo "hello"
                    echo "var = ${var}"
                    echo "env.var = ${env.var}"
                }
            }
        }
    }
}
