plugins {
    id("com.gradle.enterprise") version "3.16.1"
    id("org.danilopianini.gradle-pre-commit-git-hooks") version "1.1.18"
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
