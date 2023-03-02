plugins {
    id("com.gradle.enterprise") version "3.12.4"
    id("org.danilopianini.gradle-pre-commit-git-hooks") version "1.1.3"
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
