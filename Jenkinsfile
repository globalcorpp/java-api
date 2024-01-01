pipeline {
    agent any
    tools{
        maven 'Maven'
    }

    stages {
        stage('check Source Code and Clone') {
            steps {
                git branch: 'main', url: 'https://github.com/globalcorpp/java-api.git/'
                //sh 'git clone https://github.com/globalcorpp/java-api.git/'
            }

        }
        stage('Build jar file') {
            steps {

                //sh 'mvn --version'
                sh 'mvn clean package'
            }
        }
                stage('Build Docker Image') {
            steps {
                sh 'docker build -t java-api:v1 .'
                sh 'docker tag java-api:v1 globalcorp/java-api:v1'
            }
        }
                stage('Deploy Docker Image') {
            steps {
                //sh 'docker stop java-api'
                //sh 'docker run -itd --rm --name java-api -p 8181:8181 java-api:v1'
                sh "docker stop java-api || true && docker rm java-api || true"
                //sh 'docker-compose version'
                //sh 'docker-compose down'
                sh 'docker-compose up -d'
            }
        }
                stage('Deploy to Kubernetes'){
            steps{
                script{
                    withKubeConfig(caCertificate: '', clusterName: '', contextName: '', credentialsId: 'k8s', namespace: '', restrictKubeConfigAccess: false, serverUrl: '') {
                       sh '/usr/bin/kubectl delete -f k8s-deployment.yml'
                       sh '/usr/bin/kubectl apply -f k8s-deployment.yml'
                  }
                }
            }
        }
    }
}
