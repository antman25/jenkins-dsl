node()
{
    stage('Git Clone')
    {
    checkout([$class: 'GitSCM',
                branches: [[name: env.gitlabSourceBranch]],
                extensions: [],
                userRemoteConfigs:
                [[credentialsId: 'jenkins_ssh', url: 'http://gitlab.antlinux.local:30080/antman/jenkins-dsl.git']]])
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
