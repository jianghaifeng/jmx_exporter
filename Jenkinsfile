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
                    echo "${GIT_COMMIT}"
                    sh "echo ${GIT_COMMIT} > gitCommit.txt"
                    sh "cat gitCommit.txt"
                    stash name: "gitCommit", includes: "gitCommit.txt"
                    echo "var = ${var}"
                    echo "env.var = ${env.var}"
                    var = 4
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
                    unstash name: "gitCommit"
                    sh "cat gitCommit.txt"
                    echo "hello"
                    echo "var = ${var}"
                    echo "env.var = ${env.var}"
                }
            }
        }
    }
}
