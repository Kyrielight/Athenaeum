load("@rules_kotlin//kotlin:jvm.bzl", "kt_jvm_library")

kt_jvm_library(
    name = "routing",
    srcs = glob(["**/*.kt"]),
    deps = [
        "//moe/best/athenaeum/app:kotlin_serialization",
        "@maven//:io_ktor_ktor_server_resources_jvm",
    ],
    visibility = [
        "//visibility:public"
    ]
)
