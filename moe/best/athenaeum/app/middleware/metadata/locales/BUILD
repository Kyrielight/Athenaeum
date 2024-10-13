load("@rules_kotlin//kotlin:jvm.bzl", "kt_jvm_library")

package(default_visibility = ["//visibility:public"])

kt_jvm_library(
    name = "locales",
    srcs = ["Locales.kt"],
    deps = [
        "//moe/best/athenaeum/app/routing:bunny",
        "@maven//:io_ktor_ktor_http_jvm",
        "@maven//:io_ktor_ktor_server_core_jvm",
    ],
)