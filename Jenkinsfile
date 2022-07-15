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
      
     }
}
