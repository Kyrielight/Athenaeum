load("@rules_kotlin//kotlin:jvm.bzl", "kt_jvm_library")

kt_jvm_library(
    name = "startup",
    srcs = glob(["**/*.kt"]),
    deps = [
        "//moe/best/athenaeum/app/command:commands",
    ],
    visibility = [
        "//visibility:public"
    ]
)