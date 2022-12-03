package lecture11_unit_test_mockito.lecture2.users_program;

import org.junit.platform.engine.discovery.DiscoverySelectors;
import org.junit.platform.launcher.LauncherDiscoveryRequest;
import org.junit.platform.launcher.TagFilter;
import org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder;
import org.junit.platform.launcher.core.LauncherFactory;
import org.junit.platform.launcher.listeners.SummaryGeneratingListener;

import java.io.PrintWriter;
import java.util.regex.Pattern;

public class TestLauncher {
    public static void main(String[] args) {
        final var launcher = LauncherFactory.create();
        final var summaryGeneratingListener = new SummaryGeneratingListener();
        LauncherDiscoveryRequest request = LauncherDiscoveryRequestBuilder
                .request()
                //.selectors(DiscoverySelectors.selectClass(UserServiseTest.class))
                .selectors(DiscoverySelectors.selectPackage("lecture11_unit_test_mockito.lecture2.users_program"))
                .filters(TagFilter.includeTags("login"))
                .listeners()
                .build();

        launcher.execute(request, summaryGeneratingListener);

        try (var writer = new PrintWriter(System.out)) {
            summaryGeneratingListener.getSummary().printTo(writer);
        }
    }
}
