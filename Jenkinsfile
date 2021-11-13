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
    stage('Create Branches')
    {
        def branches = git_helper.getRemoteBranches('http://gitlab.antlinux.local:30080/antman/jenkins-dsl.git')
        print("Branches: ${branches}")
        branches.each {branch_name ->
            print("Creating Branch Folder")
            jobDsl scriptText: "folder('${branch_name}')"
        }

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
