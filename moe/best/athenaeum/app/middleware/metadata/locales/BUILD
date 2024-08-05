load("@rules_kotlin//kotlin:jvm.bzl", "kt_jvm_library")

kt_jvm_library(
    name = "locales",
    srcs = glob(["**/*.kt"]),
    deps = [
        "//moe/best/athenaeum/app/routing:routing",
        "@maven//:io_ktor_ktor_http_jvm",
        "@maven//:io_ktor_ktor_server_core_jvm",
    ],
    visibility = [
        "//visibility:public"
    ]
)