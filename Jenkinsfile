pipeline {
    agent {
      node {label 'maven'}
    }
      parameters {
        choice(name: 'BROWSER_NAME', choices: ['chrome', 'firefox'], description: 'Pick the target browser in Selenoid')
        choice(name: 'BROWSER_VERSION', choices: ['103.0', '85.0', '78.0'], description: 'Pick the target browser version in Selenoid')
    }
      stages {
        
        stage ('Run tests'){
            steps {sh """
             mvn clean test
             """ 
                  } }
          
         post {
        always {
               sh """
               chmod -R o+xw allure-results
               allure includeProperties: false, jdk: '', results: [[path: 'allure-results']]
               """
        }}
     }
}
