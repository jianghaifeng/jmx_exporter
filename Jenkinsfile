def var = 1

pipeline {
    options {
        preserveStashes(buildCount: 50) 
    }
    agent none
    stages {
        stage ('stage1') {
            agent any
            steps {
                script {
                    echo "var = ${var}"
                    echo "env.var = ${env.var}"
                    var = 2
                    env.var = 2
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
