load("@io_bazel_rules_kotlin//kotlin:jvm.bzl", "kt_jvm_binary")
load("@io_bazel_rules_kotlin//kotlin:core.bzl", "define_kt_toolchain")

define_kt_toolchain(
    name = "kotlin_toolchain",
    api_version = "1.6",
    jvm_target = "1.8",
    language_version = "1.6"
)

kt_jvm_binary(
    name = "usagi",
    main_class = "moe.best.athenaeum.Main",
    runtime_deps = [
        "//moe/best/athenaeum/app:main"
    ]
)
