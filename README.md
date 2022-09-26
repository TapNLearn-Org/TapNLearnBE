# TapNLearn
This is a project created for first step learning of kids. This project has 2 modules:
1. tapnlearnbe
   1. This module exposes the api that are consumed by tapnlearn module to display the functionality.
2. tapnlearn 
   1. This module is the frontend of the application. It is written in react native. Always remember this project is in React Native. So look for solutions only with react native libraries.

## Environment Settings
Following will be the working mechanism for developing the project.
1. For **Dev** Env:
   1. if a person is working **only on tapnlearnbe** project
      1. Database: To be installed in local machine, initialization will be done by liquibase.
      2. Static Content: Will be setup in Dev Env in AWS Account. 
      3. API will be called/tested using localhost url. 
   2. if a person is working **only on tapnlearn** project
      1. **Backend API** will be called from expo client using the **release env** endpoint.
      2. expo server will have to be started on local machine to do dev and testing.
      3. expo client needs to be installed on the phone to call the local server.
   3. if a person is working on **both tapnlearnbe and tapnlearn** project
      1. Database: To be installed in local machine, initialization will be done by liquibase.
      2. Static Content: Will be setup in Dev Env in AWS Account.
      3. API will be called/tested using localhost url.
      4. **Backend API** will be called from expo client using the **localhost env** endpoint.
      5. expo server will have to be started on local machine to do dev and testing.
      6. expo client needs to be installed on the phone to call the local server.
2. For **Release** Env:
   1. tapnlearnbe:
      1. spring boot will be installed on lambda function.
      2. swagger will be installed in the api gateway.
      3. it will connect to mysql db in aws.
   2. tapnlearn
      1. will be packaged and uploaded to expo-website.
      2. it has to be downloaded from there and installed on mobile to do testing. 
3. For **PROD** Env:
   1. tapnlearnbe:
       1. spring boot will be installed on lambda function.
       2. swagger will be installed in the api gateway.
       3. it will connect to mysql db in aws.
   2. tapnlearn
       1. will be packaged and uploaded to expo-website.
       2. it has to be downloaded from there and installed on mobile to do testing.

## GIT Branching Strategy
Follow following guidelines to commit code to the repository of back-end and front-end project.
1. Always create a feature branch from **develop** branch.
2. Naming convention of the feature branch will be **"feature/[base branch eg. develop]/[JIRA No.]"** eg. feature/develop/TAP-1
3. Jira ticket number can be get from https://amankachhal.atlassian.net/jira/software/projects/TAP/boards/1/backlog
4. create a pull request from develop to release and from release to master. 
5. if all is not to be merged to release or master branch then create a feature branch from it and then check-in the code and create pull request.
6. All the comments should follow the format **"[JIRA No.] Details about changes"** example [TAP-16] added the documentation about project.

## tapnlearn Front-End Project Setup
### Checkout the code.
Execute the following command to checkout the code and install library.
```
git clone https://github.com/TapNLearn-Org/TapNLearn.git
npm install @react-navigation/native
expo install react-native-screens react-native-safe-area-context
```
### Deploy to Android Play Store
* Update the version of the app in app.json -> version & app.json -> android -> versionCode.
* Build the application using command expo build:android -t app-bundle
* download the latest build from https://expo.dev/accounts/aman.kachhal99/projects/TapNLearn/builds
* Go to https://play.google.com/console/u/0/developers/6668536516142373952/app/4972841234965412753/tracks/production to create a new release to android play store.
* Upload the information and build and Review Release and Start Rollout.

## Package to Android ABB
* expo build:android -t apk
* expo login

## tapnlearnbe Back-end Project Setup
### Checkout the code.
Execute the following command to checkout the code.
```
git clone https://github.com/TapNLearn-Org/TapNLearnBE.git
```

### Start with AWS
* Create root account in AWS. 

### Start the Database on local machine.
* create the database with below script.
* Login in the database using root credential 
  * username: root
  * password: P@ssw0rd
```
// create database
create database tapnlearn;
CREATE USER 'tapnlearnadmin'@'%' IDENTIFIED BY 'P@ssw0rd';
GRANT ALL PRIVILEGES ON tapnlearn.* TO 'tapnlearnadmin'@'%' WITH GRANT OPTION;
FLUSH PRIVILEGES;
```
* Login in the database using tapnlearnadmin credential
  * username: tapnlearnadmin
  * password: P@ssw0rd
* use startup scripts to create sql objects.
