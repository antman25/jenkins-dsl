@Library('jenkins-shared-lib') _

node()
{
    /*stage('Git Clone')
    {
        checkout([$class: 'GitSCM',
                    branches: [[name: env.gitlabSourceBranch]],
                    extensions: [],
                    userRemoteConfigs:
                    [[credentialsId: 'jenkins_ssh', url: 'http://gitlab.antlinux.local:30080/antman/jenkins-dsl.git']]])
    }*/
    stage('Get Branches')
    {
        def branches = git_helper.getRemoteBranches('http://gitlab.antlinux.local/antman/jenkins-dsl.git')
        print("Branches: ${branches}")
    }

    stage('ENV DUmp')
    {
        updateGitlabCommitStatus name: 'build', state: 'pending'
        sh ('env | sort -n')
        updateGitlabCommitStatus name: 'build', state: 'success'
    }
    stage('test')
    {
        updateGitlabCommitStatus name: 'test', state: 'pending'
        sh ('env | sort -n')
        updateGitlabCommitStatus name: 'test', state: 'success'
    }


}
