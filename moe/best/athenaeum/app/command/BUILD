load("@rules_kotlin//kotlin:jvm.bzl", "kt_jvm_library")

kt_jvm_library(
    name = "commands",
    srcs = glob(["**/*.kt"]),
    deps = [
        "//moe/best/athenaeum/app/middleware/metadata:metadata",
        "@maven//:io_ktor_ktor_http_jvm",
    ],
    visibility = [
        "//visibility:public"
    ]
)