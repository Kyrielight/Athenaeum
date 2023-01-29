load("@io_bazel_rules_kotlin//kotlin:jvm.bzl", "kt_jvm_test")

# Custom helper method to quickly write basic test cases for Modules.
def athena_module_test(test_class, deps = [], **kwargs):
    kt_jvm_test(
        # Pipe the test class to the Console Launcher.
        args = ["--select-class={}".format(test_class)],
        # Append JUnit5 test dependencies.
        deps = deps + [
            "@maven//:org_junit_jupiter_junit_jupiter_api", # Used in test files.
            "@maven//:org_junit_jupiter_junit_jupiter_engine", # Test Engine
            # "@maven//:org_junit_platform_junit_platform_runner",
            "@maven//:org_junit_platform_junit_platform_console", # Console Launcher
        ],
        main_class = "org.junit.platform.console.ConsoleLauncher",
        **kwargs
    )