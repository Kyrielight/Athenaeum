load("//moe/best/athenaeum/apptests/common:helpers.bzl", "athena_module_test")

test_suite(
    name = "all_tests",
    tests = [
        ":jisho_test"
    ],
)

athena_module_test(
    name = "jisho_test",
    srcs = ["JishoTest.kt"],
    test_class = "moe.best.athenaeum.apptests.udc.dictionaries.JishoTest",
)
