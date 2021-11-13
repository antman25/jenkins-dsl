@Library('jenkins-shared-lib') _

node()
{
    //print("gitlabSourceBranch = ${env.gitlabSourceBranch}")
    print("ENV = ${env.getEnvironment()}")
    def source_branch = env.getEnvironment().getOrDefault("BRANCH_NAME", "main")


    /*stage('Git Clone')
    {

        checkout([$class: 'GitSCM',
                            branches: [[name: source_branch]],
                            extensions: [],
                            userRemoteConfigs:
                            [[credentialsId: 'jenkins_ssh', url: 'http://gitlab.antlinux.local:30080/antman/jenkins-dsl.git']]])

    }*/

    def root_path = "/build-root-gitlab"
    stage('Create Build Root')
    {
        def branches = git_helper.getRemoteBranches('http://gitlab.antlinux.local:30080/antman/jenkins-dsl.git')
        print("Branches: ${branches}")

        jobDsl scriptText: "folder('${root_path}')",
               removedJobAction: 'DELETE',
               removedViewAction: 'DELETE',
               lookupStrategy: 'SEED_JOB'

       branches.each {branch_name ->
            print("Creating Branch Folder")
            jobDsl scriptText: "folder('${root_path}/${branch_name}')",
                   removedJobAction: 'DELETE',
                   removedViewAction: 'DELETE',
                   lookupStrategy: 'SEED_JOB'
        }

    }

    stage ('Run Job DSL')
    {
        stage('Create Jobs')
            {
                 jobDsl targets: ["dsl/jobs/build_root.groovy"].join('\n'),
                 removedJobAction: 'DELETE',
                 removedViewAction: 'DELETE',
                 lookupStrategy: 'SEED_JOB',
                 additionalParameters: [BUILD_BRANCH: "${env.gitlabSourceBranch}"]
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
    stage('test_branch4')
    {
        echo "from 4"
    }


}
