load("//moe/best/athenaeum/apptests/common:helpers.bzl", "athena_module_test")

test_suite(
    name = "all_tests",
    tests = [
        "//moe/best/athenaeum/apptests/udc/dictionaries:all_tests",
        "//moe/best/athenaeum/apptests/udc/knowledge:all_tests",
        "//moe/best/athenaeum/apptests/udc/social:all_tests",
        ":GoogleTest",
    ],
)

athena_module_test(
    name = "GoogleTest",
    srcs = ["GoogleTest.kt"],
    test_class = "moe.best.athenaeum.apptests.udc.GoogleTest",
)
