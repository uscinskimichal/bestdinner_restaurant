pipeline {
  agent any

  triggers {
      pollSCM('H * * * *')
  }

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
          build job: 'deploy-to-staging'
          }
        }


    stage('Deploy to prod'){
        steps{
          timeout(time:5, unit:'DAYS'){
          input message:'Approve PRODUCTION Deployment?'
                      }

          build job: 'deploy-to-prod'
        }
        post {
          success {
            echo 'Code deployed to Production.'
            }

          failure {
            echo ' Deployment failed.'
            }
        }

    }

  }
}
