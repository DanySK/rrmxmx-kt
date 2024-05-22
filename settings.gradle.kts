plugins {
    id("com.gradle.enterprise") version "3.17.4"
    id("org.danilopianini.gradle-pre-commit-git-hooks") version "2.0.6"
}

gradleEnterprise {
    buildScan {
        termsOfServiceUrl = "https://gradle.com/terms-of-service"
        termsOfServiceAgree = "yes"
        publishOnFailure()
    }
}

gitHooks {
    commitMsg { conventionalCommits() }
    createHooks()
}

rootProject.name = "rrmxmx-kt".toLowerCase()
