def call(serverip){
  ARTIFACTORY_ACCESS_TOKEN = credentials('artifactory-access-token')
  JFROG_PASSWORD = credentials('jfrog-password')
  sh "jf rt upload --url http://serverip/artifactory/ --access-token ${ARTIFACTORY_ACCESS_TOKEN} target/kubernetes-configmap-reload-0.0.1-SNAPSHOT.jar java-web-app/"
}
  
