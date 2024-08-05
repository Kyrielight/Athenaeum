load("@rules_kotlin//kotlin:jvm.bzl", "kt_jvm_library")

package_group(
    name = "pg_udc_social",
    packages = [
        "//moe/best/athenaeum/app/udc/social",
    ],
)

kt_jvm_library(
    name = "udc_social",
    srcs = [
        "SocialLoader.generated.kt",
        "YouTube.kt",
    ],
    deps = [
        "//moe/best/athenaeum/app/command:commands",
        "//moe/best/athenaeum/app/middleware/metadata:metadata",
        "//moe/best/athenaeum/app/middleware/metadata/locales/common:common",
        "//moe/best/athenaeum/app/startup:startup",
        "//moe/best/athenaeum/app/startup/loader:loader",
        "@maven//:io_ktor_ktor_http_jvm",
    ],
    visibility = [
        "//moe/best/athenaeum/app/udc:pg_udc_root"
    ]
)