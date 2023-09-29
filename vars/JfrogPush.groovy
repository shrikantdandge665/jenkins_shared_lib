def call(String version, String artifactPath) {
    node {
        def targetPath = "http://54.90.54.5:8082/artifactory/java-web-app/Assignment-2-${version}.jar"
        withCredentials([usernamePassword(
            credentialsId: "jfrog",
            usernameVariable: "USER",
            passwordVariable: "PASS"
            )])    
        try {
            //sh "jfrog rt u ${artifactPath} ${targetPath} --user=${username} --password=${password}"
            sh "curl -u '$USER':'$PASS' -X PUT -T ${artifactPath} ${targetPath}"
            echo "Uploaded JAR artifact to Artifactory: ${targetPath}"
        } catch (Exception e) {
            error "Failed to upload JAR artifact to Artifactory: ${e.message}"
        }
    }
}
