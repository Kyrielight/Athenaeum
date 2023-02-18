load("@bazel_tools//tools/build_defs/repo:http.bzl", "http_archive")

JUNIT5_JUPITER_VERSION = "5.8.2"
JUNIT5_PLATFORM_VERSION = "1.8.2"
KTOR_VERSION = "2.2.2"
MOCKITO_VERSION = "4.6.1"
MOCKK_VERSION = "1.13.1"
SERIALISATION_VERSION = "1.4.1"
# KOTLINX_SERIALIZATION_VERSION = "1.0.1"

rules_kotlin_version = "v1.7.1"
rules_kotlin_sha = "fd92a98bd8a8f0e1cdcb490b93f5acef1f1727ed992571232d33de42395ca9b3"
http_archive(
    name = "io_bazel_rules_kotlin",
    urls = ["https://github.com/bazelbuild/rules_kotlin/releases/download/%s/rules_kotlin_release.tgz" % rules_kotlin_version],
    sha256 = rules_kotlin_sha,
)

load("@io_bazel_rules_kotlin//kotlin:repositories.bzl", "kotlin_repositories", "kotlinc_version")
kotlin_repositories(
    compiler_release = kotlinc_version(
        release = "1.7.20", # just the numeric version
        sha256 = "5e3c8d0f965410ff12e90d6f8dc5df2fc09fd595a684d514616851ce7e94ae7d"
    )
)

load("@io_bazel_rules_kotlin//kotlin:core.bzl", "kt_register_toolchains")
kt_register_toolchains()
# register_toolchains("//:kotlin_toolchain")

RULES_JVM_EXTERNAL_TAG = "4.5"
RULES_JVM_EXTERNAL_SHA = "b17d7388feb9bfa7f2fa09031b32707df529f26c91ab9e5d909eb1676badd9a6"

http_archive(
    name = "rules_jvm_external",
    strip_prefix = "rules_jvm_external-%s" % RULES_JVM_EXTERNAL_TAG,
    sha256 = RULES_JVM_EXTERNAL_SHA,
    url = "https://github.com/bazelbuild/rules_jvm_external/archive/%s.zip" % RULES_JVM_EXTERNAL_TAG,
)

load("@rules_jvm_external//:repositories.bzl", "rules_jvm_external_deps")
rules_jvm_external_deps()
load("@rules_jvm_external//:setup.bzl", "rules_jvm_external_setup")
rules_jvm_external_setup()
load("@rules_jvm_external//:defs.bzl", "maven_install")


maven_install(
    artifacts = [
        # JUnit 5 && Mockito
        "org.junit.jupiter:junit-jupiter-api:%s" % JUNIT5_JUPITER_VERSION,
        "org.junit.jupiter:junit-jupiter-engine:%s" % JUNIT5_JUPITER_VERSION,
        "org.junit.platform:junit-platform-runner:%s" % JUNIT5_PLATFORM_VERSION,
        "org.junit.platform:junit-platform-console:%s" % JUNIT5_PLATFORM_VERSION,
        # Ktor
        "io.ktor:ktor-http-jvm:%s" % KTOR_VERSION,
        "io.ktor:ktor-client-core-jvm:%s" % KTOR_VERSION,
        "io.ktor:ktor-server-jvm:%s" % KTOR_VERSION,
        "io.ktor:ktor-server-netty-jvm:%s" % KTOR_VERSION,
        "io.ktor:ktor-server-core-jvm:%s" % KTOR_VERSION,
        "io.ktor:ktor-server-host-common-jvm:%s" % KTOR_VERSION,
        "io.ktor:ktor-server-resources-jvm:%s" % KTOR_VERSION,
        "io.ktor:ktor-server-status-pages-jvm:%s" % KTOR_VERSION,
        "io.ktor:ktor-server-test-host-jvm:%s" % KTOR_VERSION,
        # Serialization
        "org.jetbrains.kotlinx:kotlinx-serialization-core-jvm:%s" % SERIALISATION_VERSION,
    ],
    repositories = [
        "https://repo1.maven.org/maven2/",
    ]
)
