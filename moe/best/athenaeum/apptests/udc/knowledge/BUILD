load("//moe/best/athenaeum/apptests/common:helpers.bzl", "athena_module_test")

test_suite(
    name = "all_tests",
    tests = [
        ":wikipedia_test"
    ],
)

athena_module_test(
    name = "wikipedia_test",
    srcs = ["WikipediaTest.kt"],
    test_class = "moe.best.athenaeum.apptests.udc.knowledge.WikipediaTest",
)
