@Library('jenkins-shared-lib@main') _

node("DOCKER")
{
    //print("gitlabSourceBranch = ${env.gitlabSourceBranch}")
    //print("ENV = ${env.getEnvironment()}")
    //def source_branch = env.getEnvironment().getOrDefault("BRANCH_NAME", "main")
    //ws('/mnt/scratch/appdata/jenkins_workspace')
    //{
        stage('CLone jenkins-dsl')
        {
            checkout scm
        }

        def repo_url = 'http://gitlab.antlinux.local:30080/antman/data_center.git'
        def cred_id = 'jenkins_ssh'
        def source_branch = env.getEnvironment().getOrDefault("gitlabSourceBranch", "main")
        def local_head = git_helper.getLocalHEAD()
        def active_branches = git_helper.testFunc()
        def job_root = "/build-root-mymultibranch"


        stage ("ENV Dump")
        {
            sh ("env | sort -n")
            //print("Active Branches: ${active_branches}")
            print("local head: ${local_head}")
        }

        /*

        stage('Git Clone')
        {
            jobDsl scriptText: "folder('${job_root}')",
                   removedJobAction: 'DELETE',
                   removedViewAction: 'DELETE',
                   lookupStrategy: 'SEED_JOB'

            active_branches.each { cur_branch ->
                jobDsl scriptText: "folder('${job_root}/${cur_branch}')",
                       removedJobAction: 'DELETE',
                       removedViewAction: 'DELETE',
                       lookupStrategy: 'SEED_JOB'
                dir (cur_branch)
                {
                    checkout([$class: 'GitSCM',
                                branches: [[name: cur_branch]],
                                extensions: [],
                                userRemoteConfigs:
                                [[credentialsId: cred_id, url: repo_url]]])
                }
            }
        }*/
    //}
}
