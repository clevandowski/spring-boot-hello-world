node('maven') {
  stage('build') {
    openshiftBuild(buildConfig: 'spring-boot-hello-world', showBuildLogs: 'true')
  }
  stage('deploy-development') {
    openshiftDeploy(deploymentConfig: 'spring-boot-hello-world')
  }
  stage('validation') {
    input message: 'Valider ?', ok: 'Oui'
  }
  stage('deploy-integration') {
    openshiftDeploy(deploymentConfig: 'spring-boot-hello-world', namespace: 'integration')
  }
}
