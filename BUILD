load("@rules_java//java:defs.bzl", "java_binary")
load("@rules_kotlin//kotlin:core.bzl", "define_kt_toolchain")
load("@rules_kotlin//kotlin:jvm.bzl", "kt_jvm_binary")

define_kt_toolchain(
    name = "kotlin_toolchain",
    api_version = "1.6",
    jvm_target = "1.8",
    language_version = "1.6"
)

kt_jvm_binary(
    name = "usagi",
    main_class = "moe.best.athenaeum.Main",
    runtime_deps = [
        "//moe/best/athenaeum/app:main"
    ]
)

# For production releases
java_binary(
    name = "jusagi",
    main_class = "moe.best.athenaeum.Main",
    runtime_deps = [
        "//moe/best/athenaeum/app:main"
    ]
)

# Run this target to run all tests in Usagi
test_suite(
    name = "all_tests",
    tests = [
        "//moe/best/athenaeum/apptests:all_tests"
    ]
)
