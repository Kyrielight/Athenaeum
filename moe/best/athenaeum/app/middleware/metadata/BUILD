load("@rules_kotlin//kotlin:jvm.bzl", "kt_jvm_library")

kt_jvm_library(
    name = "metadata",
    srcs = ["Metadata.kt"],
    deps = [
        "//moe/best/athenaeum/app/middleware/metadata/locales",
        "//moe/best/athenaeum/app/routing:bunny",
        "@maven//:io_ktor_ktor_server_core_jvm",
    ],
    visibility = [
        "//visibility:public"
    ]
)