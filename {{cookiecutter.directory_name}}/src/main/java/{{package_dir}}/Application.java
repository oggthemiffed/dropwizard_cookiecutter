package {{cookiecutter.package}};

import com.fasterxml.jackson.databind.SerializationFeature;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import ru.vyarus.dropwizard.guice.GuiceBundle;

public class MicroServiceApplication extends Application<MicroServiceConfiguration> {

    public static void main(final String[] args) throws Exception {
        new MicroServiceApplication().run(args);
    }

    @Override
    public String getName() {
        return "{{cookiecutter.application_name}}";
    }

    @Override
    public void initialize(final Bootstrap<MicroServiceConfiguration> bootstrap) {
        // TODO: application initialization
        bootstrap.addBundle(GuiceBundle.builder()
                .enableAutoConfig(getClass().getPackage().getName())
                .printConfigurationBindings()
                .build());
    }

    @Override
    public void run(final MicroServiceConfiguration configuration,
                    final Environment environment) {
        // TODO: implement application
        environment.getObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
    }

}

