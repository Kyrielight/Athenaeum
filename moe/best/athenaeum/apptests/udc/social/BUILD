load("//moe/best/athenaeum/apptests/common:helpers.bzl", "athena_module_test")

test_suite(
    name = "all_tests",
    tests = [
        ":youtube_test"
    ],
)

athena_module_test(
    name = "youtube_test",
    srcs = glob(["**/*.kt"]),
    test_class = "moe.best.athenaeum.apptests.udc.social.YouTubeTest",
)
