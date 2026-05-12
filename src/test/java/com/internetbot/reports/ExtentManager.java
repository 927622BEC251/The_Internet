package com.internetbot.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.nio.file.Files;
import java.nio.file.Path;

public final class ExtentManager {
    private static final Path REPORT_DIR = Path.of("reports");
    private static ExtentReports extentReports;

    private ExtentManager() {
    }

    public static synchronized ExtentReports getReporter() {
        if (extentReports == null) {
            try {
                Files.createDirectories(REPORT_DIR);
            } catch (Exception exception) {
                throw new IllegalStateException("Unable to create report directory", exception);
            }
            ExtentSparkReporter sparkReporter = new ExtentSparkReporter(REPORT_DIR.resolve("InternetBotReport.html").toString());
            sparkReporter.config().setDocumentTitle("InternetBot Automation Report");
            sparkReporter.config().setReportName("InternetBot Test Execution");
            sparkReporter.config().setTheme(Theme.DARK);
            sparkReporter.config().setCss(customReportCss());

            extentReports = new ExtentReports();
            extentReports.attachReporter(sparkReporter);
            extentReports.setSystemInfo("Framework", "Selenium Java TestNG POM");
            extentReports.setSystemInfo("Application", "The Internet Herokuapp");
            extentReports.setSystemInfo("Report", "Screenshot on Failure Enabled");
        }
        return extentReports;
    }

    public static synchronized void flush() {
        if (extentReports != null) {
            extentReports.flush();
        }
    }

    private static String customReportCss() {
        return """
                body {
                    background: #0f172a;
                    color: #e5e7eb;
                    font-family: Inter, Segoe UI, Arial, sans-serif;
                }

                .nav-wrapper, .side-nav, .brand-logo {
                    background: #111827 !important;
                }

                .test-wrapper, .card-panel, .collapsible-header, .collapsible-body {
                    border-radius: 10px !important;
                    border: 1px solid rgba(148, 163, 184, 0.22) !important;
                    box-shadow: 0 12px 32px rgba(2, 6, 23, 0.35) !important;
                }

                .test-name, .report-name {
                    letter-spacing: 0;
                    font-weight: 700;
                }

                .badge.pass-bg, .pass {
                    background: #10b981 !important;
                    color: #052e1b !important;
                }

                .badge.fail-bg, .fail {
                    background: #ef4444 !important;
                    color: #fff !important;
                }

                .badge.skip-bg, .skip {
                    background: #f59e0b !important;
                    color: #111827 !important;
                }

                table.striped > tbody > tr:nth-child(odd) {
                    background: rgba(148, 163, 184, 0.08);
                }

                img {
                    border-radius: 8px;
                    border: 1px solid rgba(148, 163, 184, 0.35);
                    box-shadow: 0 10px 28px rgba(0, 0, 0, 0.35);
                }
                """;
    }
}
