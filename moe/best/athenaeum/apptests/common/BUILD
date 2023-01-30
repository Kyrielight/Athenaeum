load("@io_bazel_rules_kotlin//kotlin:jvm.bzl", "kt_jvm_library")

kt_jvm_library(
    name = "module_test_helper",
    srcs = glob(["**/*.kt"]),
    deps = [
        "//moe/best/athenaeum/app:main", # Import Application modules
        "@maven//:io_ktor_ktor_client_core_jvm",
        "@maven//:io_ktor_ktor_http_jvm",
        "@maven//:io_ktor_ktor_server_test_host_jvm",
        "@maven//:org_junit_jupiter_junit_jupiter_api", # Used in test files.
        "@maven//:org_junit_jupiter_junit_jupiter_engine", # Test Engine
        "@maven//:org_junit_platform_junit_platform_console", # Console Launcher
    ],
    resources = [
        "//moe/best/athenaeum/resources:application.conf"
    ],
    # Configuration is expected to live at /{application.conf}
    resource_strip_prefix = "moe/best/athenaeum/resources",
    visibility = [
        "//moe/best/athenaeum/apptests:__subpackages__",
    ]
)
