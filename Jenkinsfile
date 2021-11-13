node()
{

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
