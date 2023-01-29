load("@io_bazel_rules_kotlin//kotlin:jvm.bzl", "kt_jvm_library")

kt_jvm_library(
    name = "loader",
    srcs = glob(["**/*.kt"]),
    deps = [
        "//moe/best/athenaeum/app/command:commands",
        "//moe/best/athenaeum/app/library:library",
    ],
    visibility = [
        "//visibility:public"
    ]
)