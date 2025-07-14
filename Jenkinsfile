pipeline {
	agent any
	stages {
		stage('SCM Checkout') {
			steps {
				checkout scmGit(branches: [[name: 'main']],
					userRemoteConfigs: [[url: 'https://github.com/SoleSuke/Abstracta.git']])
			}
		}
		stage('Build') {
			steps {
				withMaven {
					sh 'mvn clean package'
				}
			}
		}
		stage('Test') {
			steps {
				withMaven {
					sh 'mvn test'
				}
			}
		}
	}
}