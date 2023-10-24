pipeline{
  agent any;
  environment {
    SONAR_URL = 'http://192.168.33.10:9000' // Replace with your SonarQube URL
    SONAR_LOGIN ="squ_3d73a09730e72947ad1869427eafc25f641db258" // Create a secret credential for your SonarQube token in Jenkins
  }
  
  stages{
    stage("Maven Clean and Compile"){
      steps{
        sh 'mvn clean compile'
      }
    }
    stage("SonarQube"){
      steps{
        sh "mvn sonar:sonar -Dsonar.host.url=${SONAR_URL} -Dsonar.login=${SONAR_LOGIN}"
      }

    }
  }
}
