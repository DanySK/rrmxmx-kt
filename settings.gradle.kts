plugins {
    id("com.gradle.develocity") version "3.19.1"
    id("org.danilopianini.gradle-pre-commit-git-hooks") version "2.0.20"
}

develocity {
    buildScan {
        termsOfUseUrl = "https://gradle.com/terms-of-service"
        termsOfUseAgree = "yes"
        uploadInBackground = !System.getenv("CI").toBoolean()
    }
}

gitHooks {
    commitMsg { conventionalCommits() }
    createHooks()
}

rootProject.name = "rrmxmx-kt".lowercase()
