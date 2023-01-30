load("@io_bazel_rules_kotlin//kotlin:jvm.bzl", "kt_jvm_test")

# Custom helper method to quickly write basic test cases for Modules.
def athena_module_test(test_class, deps = [], **kwargs):
    kt_jvm_test(
        # Pipe the test class to the Console Launcher.
        args = ["--select-class={}".format(test_class)],
        # Append all dependencies generally needed by a module test.
        deps = deps + [
            "//moe/best/athenaeum/app:main", # Import Application modules
            "//moe/best/athenaeum/apptests/common:module_test_helper", # Module test class
            "@maven//:io_ktor_ktor_client_core_jvm", # Http server
            "@maven//:io_ktor_ktor_http_jvm", # Http client construction
            "@maven//:io_ktor_ktor_server_test_host_jvm",
            "@maven//:org_junit_jupiter_junit_jupiter_api", # Used in test files.
            "@maven//:org_junit_jupiter_junit_jupiter_engine", # Test Engine
            "@maven//:org_junit_platform_junit_platform_console", # Console Launcher
        ],
        main_class = "org.junit.platform.console.ConsoleLauncher",
        resources = [
            "//moe/best/athenaeum/resources:application.conf"
        ],
        # Configuration is expected to live at /{application.conf}
        resource_strip_prefix = "moe/best/athenaeum/resources",
        **kwargs
    )
