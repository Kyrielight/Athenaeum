load("@rules_kotlin//kotlin:jvm.bzl", "kt_jvm_library")

package(default_visibility = ["//visibility:public"])

kt_jvm_library(
    name = "jisho",
    srcs = ["Jisho.kt",],
    deps = [
        "//moe/best/athenaeum/app/command:target",
        "//moe/best/athenaeum/app/command:pattern",
        "//moe/best/athenaeum/app/middleware/metadata",
        "//moe/best/athenaeum/app/middleware/metadata/locales/common:locales_common_mistakes",
        "//moe/best/athenaeum/app/startup:module",
        "//moe/best/athenaeum/app/startup/loader",
        "@maven//:io_ktor_ktor_http_jvm",
    ],
)

kt_jvm_library(
    name = "dictionaries_loader",
    srcs = ["DictionariesLoader.kt"],
    deps = [
        ":jisho",
        "//moe/best/athenaeum/app/command:target",
        "//moe/best/athenaeum/app/command:pattern",
        "//moe/best/athenaeum/app/middleware/metadata",
        "//moe/best/athenaeum/app/middleware/metadata/locales/common:locales_common_mistakes",
        "//moe/best/athenaeum/app/startup:module",
        "//moe/best/athenaeum/app/startup/loader",
        "@maven//:io_ktor_ktor_http_jvm",
    ],
)
