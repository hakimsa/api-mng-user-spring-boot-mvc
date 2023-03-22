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
                sh ' echo path/to/script en agent develop '
                
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
                        def fields = [project: [key: "TEST"], summary: summary, description: description, issuetype: [name: issueType]]
                        def jsonBody = JsonOutput.toJson(fields)
                        def response = httpRequest(
                            acceptType: 'APPLICATION_JSON',
                            contentType: 'APPLICATION_JSON',
                            url: 'https://hakimsamouh.atlassian.net/rest/api/2/issue/',
                            authentication: 'samouh591@gmail.com:ATATT3xFfGF0PJuc2es3q0kGiuRm-vT07fCqwUoXYrOkWyvOHVrAlKvJ7CEZBX0Oz4OpgW0ZgsPF1eb4B2oIx3NsPrd7LJ3eN07lNoVIlCfgePCt7_n302PcWWKML2OERokrvy14FWY032uTGE7ZyvIMwbvZ1AjgwM8jMJ0pLd9DZFcWImfGgqs=C9635872',
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
                sh 'echo ok'
            }
        }
    }
}
