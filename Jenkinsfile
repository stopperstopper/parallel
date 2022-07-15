pipeline {
    agent {
      node {label 'maven'}
    }
    stages {
        
        stage ('Run tests'){
            steps {sh """
             mvn clean test -Dbrowser=chrome -Dbase.url=${env.BASE_URL}
             """
            } 
        }
      
     }
}
