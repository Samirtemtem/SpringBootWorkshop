pipeline {
    agent any
    tools {
        maven 'M2_HOME' 
    }
    stages {
        stage('Hello') {
            steps {
                echo 'hello samir'
            }
        }
        
        stage('GIT') {
            steps {
                git branch: 'main',
                  url: 'https://github.com/Samirtemtem/SpringBootWorkshop.git',
                  credentialsId: '8e21e470-76bb-4f04-83c0-870e2a7a6d1a' 
            }
        }
        
        stage('compilation maven') {
steps {
                sh "mvn -version"
            }
        }
    }
}
