timeout(180)
   node('maven'){
      stage('Checkout'){
        dir('tests_selenoid'){
          checkout([
            $class: 'GitSCM',
            branches: [[name: 'refs/heads/master']],
            doGenerateSubmoduleConfigurations: false,
            submoduleCfg: [],
            userRemoteConfigs: [[url: 'https://github.com/stopperstopper/parallel.git']]
        

          ])
        }
      stage ('Run tests'){
        sh """
          mvn clean tests-Dbrowser=chrome -Dbase.url=${env.BASE_URL}
          """
      } 
      stage 
         allure([
            includeProperties: false,
            properties: [],
            reportBuildPolicy: 'ALWAYS',
            results: [[path: 'target/allure-results']]
         ])


      }

   }