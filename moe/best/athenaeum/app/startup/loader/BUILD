load("@rules_kotlin//kotlin:jvm.bzl", "kt_jvm_library")

package(default_visibility = ["//visibility:public"])

kt_jvm_library(
    name = "loader",
    srcs = ["Loader.kt"],
    deps = [
        "//moe/best/athenaeum/app/command:pattern",
        "//moe/best/athenaeum/app/command:target",
        "//moe/best/athenaeum/app/library",
    ],
)