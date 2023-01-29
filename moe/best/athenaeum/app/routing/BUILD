load("@io_bazel_rules_kotlin//kotlin:core.bzl", "kt_compiler_plugin")
load("@io_bazel_rules_kotlin//kotlin:jvm.bzl", "kt_jvm_library")

kt_compiler_plugin(
    name = "kotlin_serialization_plugin",
    compile_phase = True,
    id = "org.jetbrains.kotlin.serialization",
    stubs_phase = True,
    deps = [
        "@com_github_jetbrains_kotlin//:kotlinx-serialization-compiler-plugin",
    ],
)

kt_jvm_library(
    name = "kotlin_serialization",
    exported_compiler_plugins = [":kotlin_serialization_plugin"],
)

kt_jvm_library(
    name = "routing",
    srcs = glob(["**/*.kt"]),
    deps = [
        "@maven//:io_ktor_ktor_server_resources_jvm",
        ":kotlin_serialization",
    ],
    visibility = [
        "//visibility:public"
    ]
)
