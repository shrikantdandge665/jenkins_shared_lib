def call(String version, String artifactPath, String targetPath) {
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
