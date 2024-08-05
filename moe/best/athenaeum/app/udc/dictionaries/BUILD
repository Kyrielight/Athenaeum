load("@rules_kotlin//kotlin:jvm.bzl", "kt_jvm_library")

package_group(
    name = "pg_udc_dictionaries",
    packages = [
        "//moe/best/athenaeum/app/udc/dictionaries",
    ],
)

kt_jvm_library(
    name = "udc_dictionaries",
    srcs = [
        "DictionariesLoader.generated.kt",
        "Jisho.kt",
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
