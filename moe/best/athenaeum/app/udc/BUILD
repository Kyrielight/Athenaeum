load("@io_bazel_rules_kotlin//kotlin:jvm.bzl", "kt_jvm_library")

package_group(
    name = "pg_udc_root",
    packages = [
        "//moe/best/athenaeum/app/udc",
    ],
)

kt_jvm_library(
    name = "udc_default_google",
    srcs = [
        "Google.kt"
    ],
    deps = [
        "//moe/best/athenaeum/app/command:commands",
        "//moe/best/athenaeum/app/library:library",
        "//moe/best/athenaeum/app/middleware/locales/common:common",
        "//moe/best/athenaeum/app/startup:startup",
        "//moe/best/athenaeum/app/startup/loader:loader",
        "@maven//:io_ktor_ktor_http_jvm",
    ],
    visibility = [
        "//visibility:public"
    ]
)

kt_jvm_library(
    name = "udc_root",
    srcs = [
        "Google.kt",
        "UDCLoader.generated.kt",
    ],
    deps = [
        "//moe/best/athenaeum/app/command:commands",
        "//moe/best/athenaeum/app/library:library",
        "//moe/best/athenaeum/app/startup:startup",
        "//moe/best/athenaeum/app/startup/loader:loader",
        "@maven//:io_ktor_ktor_http_jvm",
        # Begin udc sections
        "//moe/best/athenaeum/app/udc/knowledge:udc_knowledge",
        "//moe/best/athenaeum/app/udc/social:udc_social",
    ],
    visibility = [
        # "//src/moe/best/athenaeum:root"
        "//visibility:public"
    ]
)