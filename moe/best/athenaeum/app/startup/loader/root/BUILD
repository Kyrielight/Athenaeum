load("@rules_kotlin//kotlin:jvm.bzl", "kt_jvm_library")

package(default_visibility = ["//visibility:public"])

kt_jvm_library(
    name = "root_loader",
    srcs = ["RootLoader.kt"],
    deps = [
        "//moe/best/athenaeum/app/library",
        "//moe/best/athenaeum/app/middleware/aliases",
        "//moe/best/athenaeum/app/udc:udc_loader",
    ],
    visibility = [
        "//visibility:public"
    ]
)