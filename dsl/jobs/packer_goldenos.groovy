def build_root = '/build-root-gitlab'
folder("${build_root}/${BUILD_BRANCH}/packer")

folder("${build_root}/${BUILD_BRANCH}/packer/golden-baseos")
folder("${build_root}/${BUILD_BRANCH}/packer/golden-baseos/winsvr2019")
folder("${build_root}/${BUILD_BRANCH}/packer/golden-baseos/winsvr2019/winsvr2019-JAN2021")

pipelineJob("${build_root}/${BUILD_BRANCH}/packer/golden-baseos/winsvr2019/winsvr2019-JAN2021/build") {

  def repo = 'http://gitlab.antlinux.local:30080/antman/data_center.git'

  triggers {
    gitlabPush {
      buildOnMergeRequestEvents(false)
      buildOnPushEvents(true)
      enableCiSkip(false)
      setBuildDescription(true)
      rebuildOpenMergeRequest('never')
      includeBranches('main')

    }
  }

  throttleConcurrentBuilds {
    maxTotal(1)
    maxPerNode(1)
    throttleDisabled(false)
  }
  description("Pipeline for $repo")
  parameters {
    stringParam('BUILD_BRANCH', 'main', 'build this branch')
  }
  definition {
    cpsScm {
      scm {
        git {
          remote { url(repo) }
          branches("${BUILD_BRANCH}")
          scriptPath('packer/winsvr/Jenkinsfile')
          extensions { }  // required as otherwise it may try to tag the repo, which you may not want
        }

      }
    }
  }
}


folder("${build_root}/${BUILD_BRANCH}/packer/golden-baseos/centos7")
folder("${build_root}/${BUILD_BRANCH}/packer/golden-baseos/centos7/CentOS-7.9.2009")


pipelineJob("${build_root}/${BUILD_BRANCH}/packer/golden-baseos/centos7/CentOS-7.9.2009/build") {

  def repo = 'http://gitlab.antlinux.local:30080/antman/data_center.git'

  triggers {
    gitlabPush {
      buildOnMergeRequestEvents(false)
      buildOnPushEvents(true)
      enableCiSkip(false)
      setBuildDescription(true)
      rebuildOpenMergeRequest('never')
      includeBranches('main')

    }
  }

  throttleConcurrentBuilds {
    maxTotal(1)
    maxPerNode(1)
    throttleDisabled(false)
  }
  description("Pipeline for $repo")
  parameters {
    stringParam('BUILD_BRANCH', 'main', 'build this branch')
  }
  environmentVariables {
    env('var_filepath', 'vars/stage1_iso/centos7-7.9.2009.hcl')
    env('common_triggers', "packer-library/centos/common_vm/")
    env('stage1_triggers', "packer-library/centos/ks/ks_centos8.cfg, vars/stage1_iso/centos7-7.9.2009.hcl")
    keepBuildVariables(true)
  }
  definition {
    cpsScm {
      scm {
        git {
          remote { url(repo) }
          branches('main')
          scriptPath('packer/centos/Jenkinsfile')
          extensions { }  // required as otherwise it may try to tag the repo, which you may not want
        }

      }
    }
  }
}

folder("${build_root}/${BUILD_BRANCH}/packer/golden-baseos/centos8")
folder("${build_root}/${BUILD_BRANCH}/packer/golden-baseos/centos8/CentOS-8.2.2004")

pipelineJob("${build_root}/${BUILD_BRANCH}/packer/golden-baseos/centos8/CentOS-8.2.2004/build") {

  def repo = 'http://gitlab.antlinux.local:30080/antman/data_center.git'
  triggers {
    gitlabPush {
      buildOnMergeRequestEvents(false)
      buildOnPushEvents(true)
      enableCiSkip(false)
      setBuildDescription(true)
      rebuildOpenMergeRequest('never')
      includeBranches('main')

    }
  }

  throttleConcurrentBuilds {
    maxTotal(1)
    maxPerNode(1)
    throttleDisabled(false)
  }
  description("Pipeline for $repo")
  parameters {
    stringParam('BUILD_BRANCH', 'main', 'build this branch')
  }
  environmentVariables {
    env('var_filepath', 'vars/stage1_iso/centos8-8.2.2004.hcl')
    env('common_triggers', "packer-library/centos/common_vm/")
    env('stage1_triggers', "packer-library/centos/ks/ks_centos8.cfg, vars/stage1_iso/centos8-8.2.2004.hcl")
    keepBuildVariables(true)
  }

  definition {
    cpsScm {
      scm {
        git {
          remote { url(repo) }
          branches('main')
          scriptPath('packer/centos/Jenkinsfile')
          extensions { }  // required as otherwise it may try to tag the repo, which you may not want
        }

      }
    }
  }
}

folder("${build_root}/${BUILD_BRANCH}/packer/golden-baseos/centos8/CentOS-8.4.2105")

pipelineJob("${build_root}/${BUILD_BRANCH}/packer/golden-baseos/centos8/CentOS-8.4.2105/build") {

  def repo = 'http://gitlab.antlinux.local:30080/antman/data_center.git'

  triggers {
    gitlabPush {
      buildOnMergeRequestEvents(false)
      buildOnPushEvents(true)
      enableCiSkip(false)
      setBuildDescription(true)
      rebuildOpenMergeRequest('never')
      includeBranches('main')

    }
  }

  throttleConcurrentBuilds {
    maxTotal(1)
    maxPerNode(1)
    throttleDisabled(false)
  }
  description("Pipeline for $repo")
  parameters {
    stringParam('BUILD_BRANCH', 'main', 'build this branch')
  }
  environmentVariables {
    env('var_filepath', 'vars/stage1_iso/centos8-8.4.2105.hcl')
    env('common_triggers', "packer-library/centos/common_vm/")
    env('stage1_triggers', "packer-library/centos/ks/ks_centos8.cfg, vars/stage1_iso/centos8-8.4.2105.hcl")
    keepBuildVariables(true)
  }
  definition {
    cpsScm {
      scm {
        git {
          remote { url(repo) }
          branches('main')
          scriptPath('packer/centos/Jenkinsfile')
          extensions { }  // required as otherwise it may try to tag the repo, which you may not want
        }

      }
    }
  }
}

