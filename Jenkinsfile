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
    stage('Deploy to staging'){
      steps{
      sh 'sudo apt-get update -qy'
      sh 'sudo apt-get install -y ruby-dev'
      sh 'sudo gem install dpl'
      sh 'sudo dpl --provider=heroku --app=best-dinner-back --api-key=\'ea514855-1748-4c23-901b-2cca131a5a56\''
      }
    }
  }
}
