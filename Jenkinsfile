node {
    stage('build') {
        stage('sub stage1 for build') {
            echo "actions 1"
        }
        stage('sub stage2 for build') {
            echo "actions 2"
        }
        step {
            echo "actions for build"
        }
    }
    stage('deploy') {
        echo "actions for deploy"
    }
}