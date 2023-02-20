load("@io_bazel_rules_kotlin//kotlin:jvm.bzl", "kt_jvm_library")

kt_jvm_library(
    name = "rootloader",
    srcs = glob(["**/*.kt"]),
    deps = [
        "//moe/best/athenaeum/app/command:commands",
        "//moe/best/athenaeum/app/library:library",
        "//moe/best/athenaeum/app/middleware/aliases:aliases",
        "//moe/best/athenaeum/app/udc:udc_root",
    ],
    visibility = [
        "//visibility:public"
    ]
)