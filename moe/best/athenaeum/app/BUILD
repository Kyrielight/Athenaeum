load("@rules_java//java:defs.bzl", "java_binary")
load("@rules_kotlin//kotlin:jvm.bzl", "kt_jvm_library")
load("@rules_kotlin//kotlin:core.bzl", "kt_compiler_plugin")

kt_compiler_plugin(
    name = "kotlin_serialization_plugin",
    compile_phase = True,
    id = "org.jetbrains.kotlin.serialization",
    stubs_phase = True,
    deps = [
        "@rules_kotlin//kotlin/compiler:kotlinx-serialization-compiler-plugin",
    ],
    visibility = ["//visibility:private"],
)

kt_jvm_library(
    name = "kotlin_serialization",
    exported_compiler_plugins = [":kotlin_serialization_plugin"],
    visibility = ["//visibility:public"],
)

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
        "//moe/best/athenaeum/app/command:base_command",
        "//moe/best/athenaeum/app/library",
        "//moe/best/athenaeum/app/routing:bunny",
        "//moe/best/athenaeum/app/udc:google",
        "//moe/best/athenaeum/app/startup/loader/root:root_loader",
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

java_binary(
    name = "usagi",
    main_class = "moe.best.athenaeum.Main",
    runtime_deps = [
        "//moe/best/athenaeum/app:main"
    ]
)