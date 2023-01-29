load("//moe/best/athenaeum/apptests:helpers.bzl", "athena_module_test")

athena_module_test(
    name = "youtube_test",
    deps = [
        "//moe/best/athenaeum/app/library:library",
        "//moe/best/athenaeum/app/startup/loader/root:rootloader",
    ],
    srcs = glob(["**/*.kt"]),
    test_class = "moe.best.athenaeum.apptests.udc.social.YouTubeTest",
)