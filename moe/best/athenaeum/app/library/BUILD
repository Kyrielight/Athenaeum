load("@io_bazel_rules_kotlin//kotlin:jvm.bzl", "kt_jvm_library")

package_group(
    name = "pg_library",
    packages = [
        "//moe/best/athenaeum/app/library",
    ],
)

kt_jvm_library(
    name = "library",
    srcs = glob(["**/*.kt"]),
    deps = [
        "//moe/best/athenaeum/app/command:commands",
        "//moe/best/athenaeum/app/middleware/metadata:metadata",
        "//moe/best/athenaeum/app/middleware/aliases:aliases",
        "//moe/best/athenaeum/app/routing:routing",
        "@maven//:io_ktor_ktor_http_jvm",
        "@maven//:io_ktor_ktor_server_core_jvm",
    ],
    visibility = [
        "//visibility:public"
    ]
)