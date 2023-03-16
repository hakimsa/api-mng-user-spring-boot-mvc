pipeline {
    agent any
    
    stages {
        stage('Checkout') {
            steps {
                // Checkout code from source control
                checkout scm
            }
        }
        
        stage('Test') {
            steps {
                // Run tests
                sh './run_tests.sh'
                
                // Verify if tests passed or failed
                script {
                    if (currentBuild.result == 'SUCCESS') {
                        echo "Tests passed"
                    } else {
                        echo "Tests failed"
                        
                        // Create a Jira issue
                        def summary = "Tests failed"
                        def description = "Tests failed in build #" + env.BUILD_NUMBER
                        def issueType = "Bug"
                        def fields = [project: [key: "KEY"], summary: summary, description: description, issuetype: [name: issueType]]
                        def jsonBody = JsonOutput.toJson(fields)
                        def response = httpRequest(
                            acceptType: 'APPLICATION_JSON',
                            contentType: 'APPLICATION_JSON',
                            url: 'https://hakimsamouh.atlassian.net/rest/api/2/issue/',
                            authentication: 'USERNAME:PASSWORD',
                            requestBody: jsonBody
                        )
                        echo "Jira issue created with ID " + response.data.id
                    }
                }
            }
        }
        
        stage('Build') {
            steps {
                // Generate WAR package
                sh './generate_war.sh'
            }
        }
    }
}
