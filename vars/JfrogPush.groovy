def call(String version, String artifactPath, String targetPath) {
        withCredentials([usernamePassword(
            credentialsId: 'jfrog',
            usernameVariable: 'USER',
            passwordVariable: 'PASS'
        )]) {
            sh "curl -u $USER:$PASS -X PUT -T ${artifactPath} ${targetPath}"
            echo "Uploaded JAR artifact assignment to Artifactory: ${targetPath} of version ${version} "
        }      
}
