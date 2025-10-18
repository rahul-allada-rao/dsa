// Jenkinsfile
pipeline {
    agent any 
    stages {
        stage('Checkout') {
            steps {
                // The Multibranch Pipeline automatically handles cloning the repo
                // for the specified branch. No need for an explicit git clone step.
                echo 'Source code checked out.'
            }
        }
        stage('Build') {
            steps {
                echo "Building the project on the branch: ${env.BRANCH_NAME}"
                // Add your build commands here (e.g., mvn clean install, npm build)
            }
        }
    }
}
