pipeline {
    agent {
      node {label 'maven'}
    }
     // parameters {
     //   choice(name: 'BROWSER_NAME', choices: ['chrome', 'firefox'], description: 'Pick the target browser in Selenoid')
     //   choice(name: 'BROWSER_VERSION', choices: ['103.0', '85.0', '78.0'], description: 'Pick the target browser version in Selenoid')
    //}
      stages {
        
        stage ('Run tests'){
            steps {sh """
             mvn clean test
             """ 
                  } }}
          
         post {
        always {
               script {
                    // Формирование отчета
                    allure([
                      includeProperties: false,
                      jdk: '',
                      properties: [],
                      reportBuildPolicy: 'ALWAYS',
                      results: [[path: 'target/allure-results']]
                    ])
                    println('allure report created')

                                       
                  }
        }}
     
}
