load("@io_bazel_rules_kotlin//kotlin:jvm.bzl", "kt_jvm_library")

kt_jvm_library(
    name = "udc_knowledge",
    srcs = [
        "KnowledgeLoader.generated.kt",
        "Wikipedia.kt",
    ],
    deps = [
        "//moe/best/athenaeum/app/command:commands",
        "//moe/best/athenaeum/app/middleware:middleware",
        "//moe/best/athenaeum/app/middleware/locales/common:common",
        "//moe/best/athenaeum/app/startup:startup",
        "//moe/best/athenaeum/app/startup/loader:loader",
        "@maven//:io_ktor_ktor_http_jvm",
    ],
    visibility = [
        "//moe/best/athenaeum/app/udc:pg_udc_root"
    ]
)