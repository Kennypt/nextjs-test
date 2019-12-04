pipeline {
  agent any

  // tools {nodejs "node"}

  stages {
    stage('Prepare') {
      steps {
        nvm('12.0.0')
        sh 'npm i'
      }
    }

    stage('Lint') {
      steps {
        sh 'npm run prettier && npm run lint'
      }
    }

    stage('Test') {
      steps {
        sh 'npm run test'
      }
    }
  }
}
