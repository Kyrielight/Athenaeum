load("@rules_kotlin//kotlin:jvm.bzl", "kt_jvm_library")

package(default_visibility = ["//visibility:public"])

kt_jvm_library(
    name = "bunny",
    srcs = ["Bunny.kt"],
    deps = [
        "//moe/best/athenaeum/app:kotlin_serialization",
        "@maven//:io_ktor_ktor_server_resources_jvm",
    ],
)
