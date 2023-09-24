def call(){
  ARTIFACTORY_ACCESS_TOKEN = credentials('artifactory-access-token')
  JFROG_PASSWORD = credentials('jfrog-password')
  sh "pwd"
  sh "jf rt upload --url http://100.25.200.113:8082/artifactory/ --access-token ${ARTIFACTORY_ACCESS_TOKEN} target/kubernetes-configmap-reload-0.0.1-SNAPSHOT.jar java-web-app/"
}
  
