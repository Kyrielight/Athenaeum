load("@rules_kotlin//kotlin:core.bzl", "define_kt_toolchain")

define_kt_toolchain(
    name = "kotlin_toolchain",
    api_version = "1.6",
    jvm_target = "1.8",
    language_version = "1.6"
)

# Run this target to run all tests in Usagi
test_suite(
    name = "all_tests",
    tests = [
        "//moe/best/athenaeum/apptests:all_tests"
    ]
)
