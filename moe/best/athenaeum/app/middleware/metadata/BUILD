load("@rules_kotlin//kotlin:jvm.bzl", "kt_jvm_library")

kt_jvm_library(
    name = "metadata",
    srcs = glob(["**/*.kt"]),
    deps = [
        "//moe/best/athenaeum/app/middleware/metadata/locales:locales",
        "//moe/best/athenaeum/app/routing:routing",
        "@maven//:io_ktor_ktor_server_core_jvm",
    ],
    visibility = [
        "//visibility:public"
    ]
)