package com.internetbot.data;

import com.google.gson.Gson;
import org.testng.annotations.DataProvider;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public final class LoginDataProvider {
    private static final String LOGIN_DATA_FILE = "login-data.json";

    private LoginDataProvider() {
    }

    @DataProvider(name = "loginScenarios", parallel = true)
    public static Object[][] loginScenarios() {
        try (Reader reader = new InputStreamReader(
                LoginDataProvider.class.getClassLoader().getResourceAsStream(LOGIN_DATA_FILE),
                StandardCharsets.UTF_8)) {
            LoginScenario[] scenarios = new Gson().fromJson(reader, LoginScenario[].class);
            return Arrays.stream(scenarios)
                    .map(scenario -> new Object[]{scenario})
                    .toArray(Object[][]::new);
        } catch (IOException exception) {
            throw new IllegalStateException("Unable to read " + LOGIN_DATA_FILE, exception);
        }
    }
}
