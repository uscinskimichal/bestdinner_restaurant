pipeline {
  agent any

  stages{
    stage('Build'){
      steps{
        echo "Bulding starts..."
        sh 'mvn clean package'
        echo "Bulding finished..."
      }
      post {
        success{
          echo "Now archiving..."
          archiveArtifacts artifacts: '**/target/*.jar'
        }
      }
    }
    stage('Static Code Test'){
      steps{
        build job: 'static-analysis'
      }
    }
  }
}
