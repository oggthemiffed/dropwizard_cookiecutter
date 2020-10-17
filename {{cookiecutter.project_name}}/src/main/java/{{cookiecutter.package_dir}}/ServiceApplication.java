package {{cookiecutter.package}};

import com.fasterxml.jackson.databind.SerializationFeature;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import ru.vyarus.dropwizard.guice.GuiceBundle;

public class ServiceApplication extends Application<ApplicationConfiguration> {

    public static void main(final String[] args) throws Exception {
        new ServiceApplication().run(args);
    }

    @Override
    public String getName() {
        return "{{cookiecutter.project_name}}";
    }

    @Override
    public void initialize(final Bootstrap<ApplicationConfiguration> bootstrap) {
        // TODO: application initialization
        bootstrap.addBundle(GuiceBundle.builder()
                .enableAutoConfig(getClass().getPackage().getName())
                .printConfigurationBindings()
                .build());
    }

    @Override
    public void run(final ApplicationConfiguration configuration,
                    final Environment environment) {
        // TODO: implement application
        environment.getObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
    }

}

