load("@rules_kotlin//kotlin:jvm.bzl", "kt_jvm_library")

package(default_visibility = ["//visibility:public"])

kt_jvm_library(
    name = "base_command",
    srcs = ["BaseCommand.kt"],
    deps = [
        "//moe/best/athenaeum/app/middleware/metadata",
        "@maven//:io_ktor_ktor_http_jvm",
    ],
)

kt_jvm_library(
    name = "pattern",
    srcs = ["Pattern.kt"],
    deps = [
        ":base_command",
        "//moe/best/athenaeum/app/middleware/metadata",
        "@maven//:io_ktor_ktor_http_jvm",
    ],
)

kt_jvm_library(
    name = "target",
    srcs = ["Target.kt"],
    deps = [
        ":base_command",
        "//moe/best/athenaeum/app/middleware/metadata",
        "@maven//:io_ktor_ktor_http_jvm",
    ],
)