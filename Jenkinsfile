@Library('jenkins-shared-lib') _

node()
{
    //print("gitlabSourceBranch = ${env.gitlabSourceBranch}")
    //print("ENV = ${env.getEnvironment()}")
    def source_branch = env.getEnvironment().getOrDefault("BRANCH_NAME", "main")
    //def source_branch = env.getEnvironment().getOrDefault("gitlabSourceBranch", "main")
    stage ("ENV Dump")
    {
        sh ("env | sort -n")
    }

    stage('Git Clone')
    {
        dir
        checkout([$class: 'GitSCM',
                            branches: [[name: source_branch]],
                            extensions: [],
                            userRemoteConfigs:
                            [[credentialsId: 'jenkins_ssh', url: 'http://gitlab.antlinux.local:30080/antman/jenkins-dsl.git']]])

    }

    /*def root_path = "/build-root-gitlab"
    stage('Create Build Root')
    {
        jobDsl scriptText: "folder('${root_path}')",
               removedJobAction: 'DELETE',
               removedViewAction: 'DELETE',
               lookupStrategy: 'SEED_JOB'
    }*/

    stage ('Run Job DSL')
    {
        stage('Create Jobs')
            {
                 jobDsl targets: ["dsl/jobs/build_root.groovy"].join('\n'),
                 removedJobAction: 'DELETE',
                 removedViewAction: 'DELETE',
                 lookupStrategy: 'SEED_JOB',
                 additionalParameters: [BUILD_BRANCH: "${source_branch}"]
            }
    }
}
