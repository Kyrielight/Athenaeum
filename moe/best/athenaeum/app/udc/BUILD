load("@rules_kotlin//kotlin:jvm.bzl", "kt_jvm_library")

package(default_visibility = ["//visibility:public"])

kt_jvm_library(
    name = "google",
    srcs = ["Google.kt"],
    deps = [
        "//moe/best/athenaeum/app/command:target",
        "//moe/best/athenaeum/app/command:pattern",
        "//moe/best/athenaeum/app/library",
        "//moe/best/athenaeum/app/middleware/metadata/locales/common:locales_common_mistakes",
        "//moe/best/athenaeum/app/startup:module",
        "//moe/best/athenaeum/app/startup/loader",
        "@maven//:io_ktor_ktor_http_jvm",
    ],
)

kt_jvm_library(
    name = "udc_loader",
    srcs = [
        "UDCLoader.kt",
    ],
    deps = [
        ":google",
        "//moe/best/athenaeum/app/command:target",
        "//moe/best/athenaeum/app/command:pattern",
        "//moe/best/athenaeum/app/library",
        "//moe/best/athenaeum/app/startup:module",
        "//moe/best/athenaeum/app/startup/loader",
        "@maven//:io_ktor_ktor_http_jvm",
        # Begin udc sections
        "//moe/best/athenaeum/app/udc/dictionaries:dictionaries_loader",
        "//moe/best/athenaeum/app/udc/knowledge:knowledge_loader",
        "//moe/best/athenaeum/app/udc/social:social_loader",
    ],
)