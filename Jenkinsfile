node() {
    // stage("checkout") {
    //     checkout([$class: 'GitSCM', branches: [[name: '*/jenkinsfile']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[url: 'https://github.com/clevandowski/spring-boot-hello-world.git']]])
    // }
    stage("build") {
        step([$class: 'DockerBuilderPublisher', cleanImages: false, cleanupWithJenkinsJobDelete: false, cloud: '', dockerFileDirectory: '', pullCredentialsId: '', pushCredentialsId: '', pushOnSuccess: false, tagsString: "clevandowski/spring-boot-hello-world:${BUILD_NUMBER}\nclevandowski/spring-boot-hello-world:latest"])
    }
    stage("test") {
        sleep(1)
    }
    stage("deploy rec") {
        sleep(1)
    }
    stage("deploy prod") {
        sleep(1)
    }
}
