pipeline {
    agent {
      node {label 'maven'}
    }
    stages {
        stage('Checkout'){
            steps {
               checkout([
                 $class: 'GitSCM',
                 branches: [[name: 'refs/heads/main']],
                 doGenerateSubmoduleConfigurations: false,
                 submoduleCfg: [],
                 userRemoteConfigs: [[url: 'https://github.com/stopperstopper/parallel.git']]
                  ])
            }
        }
        stage ('Run tests'){
            steps {sh """
             mvn clean tests-Dbrowser=chrome -Dbase.url=${env.BASE_URL}
             """
            } 
        }
       #  stage ('Report'){
       #    allure([
        #    includeProperties: false,
         #   properties: [],
          #  reportBuildPolicy: 'ALWAYS',
           # results: [[path: 'target/allure-results']]
            #   ])


      #}
     }
}
