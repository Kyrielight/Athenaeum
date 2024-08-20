load("@rules_kotlin//kotlin:jvm.bzl", "kt_jvm_library")

package(default_visibility = ["//visibility:public"])

kt_jvm_library(
    name = "module",
    srcs = ["Module.kt"],
    deps = [
        "//moe/best/athenaeum/app/command:pattern",
        "//moe/best/athenaeum/app/command:target",
    ],
)