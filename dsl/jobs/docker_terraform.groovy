def build_root = '/build-root-multibranch'
folder("${build_root}/${BUILD_BRANCH}/docker/terraform")

pipelineJob("${build_root}/${BUILD_BRANCH}/docker/terraform/build") {

  def repo = 'http://gitlab.antlinux.local:30080/antman/data_center.git'

  description("Pipeline for $repo")

  definition {
    cpsScm {
      scm {
        git {
          remote { url(repo) }
          branches("${BUILD_BRANCH}")
          scriptPath('docker/terraform/Jenkinsfile')
          extensions { }  // required as otherwise it may try to tag the repo, which you may not want
        }

      }
    }
  }
}

