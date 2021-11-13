def build_root = 'build-root-multibranch'
folder(build_root)
folder("${build_root}/${BUILD_BRANCH}")

folder("${build_root}/${BUILD_BRANCH}/docker")
folder('${build_root}/${BUILD_BRANCH}/packer')

pipelineJob("${build_root}/${BUILD_BRANCH}/build-master") {

  def repo = 'http://gitlab.antlinux.local:30080/antman/data_center.git'

  description("Pipeline for $repo")
  parameters {
    stringParam('BUILD_BRANCH', 'main', 'build this branch')
  }
  definition {
    cpsScm {
      scm {
        git {
          remote { url(repo) }
          branches('main')
          scriptPath('build-master/Jenkinsfile')
          extensions { }  // required as otherwise it may try to tag the repo, which you may not want
        }

      }
    }
  }
}
