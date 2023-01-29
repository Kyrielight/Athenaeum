load("@io_bazel_rules_kotlin//kotlin:jvm.bzl", "kt_jvm_library")
load("@rules_jvm_external//:defs.bzl", "artifact")


package_group(
    name = "root",
    packages = [
        "//moe/best/athenaeum/app"
    ]
)

kt_jvm_library(
    name = "main",
    srcs = ["Main.kt"],
    deps = [
        "//moe/best/athenaeum/app/command:commands",
        "//moe/best/athenaeum/app/library:library",
        "//moe/best/athenaeum/app/routing:routing",
        "//moe/best/athenaeum/app/udc:udc_default_google",
        "//moe/best/athenaeum/app/startup/loader/root:rootloader",
        "@maven//:io_ktor_ktor_http_jvm",
        "@maven//:io_ktor_ktor_server_jvm",
        "@maven//:io_ktor_ktor_server_netty_jvm",
        "@maven//:io_ktor_ktor_server_host_common_jvm", 
        "@maven//:io_ktor_ktor_server_resources_jvm",
    ],
    resources = [
        "//moe/best/athenaeum/resources:application.conf"
    ],
    # Configuration is expected to live at /{application.conf}
    resource_strip_prefix = "moe/best/athenaeum/resources",
    visibility = [
        "//visibility:public"
    ]
)
