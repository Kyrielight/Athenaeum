load("//moe/best/athenaeum/apptests/common:helpers.bzl", "athena_module_test")

test_suite(
    name = "all_tests",
    tests = [
        ":WikipediaTest"
    ],
)

athena_module_test(
    name = "WikipediaTest",
    srcs = ["WikipediaTest.kt"],
    test_class = "moe.best.athenaeum.apptests.udc.knowledge.WikipediaTest",
)
