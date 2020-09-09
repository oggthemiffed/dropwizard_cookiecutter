package {{cookiecutter.package}}.health;

import ru.vyarus.dropwizard.guice.module.installer.feature.health.NamedHealthCheck;

import javax.inject.Singleton;

@Singleton
public class BasicHealthCheck extends NamedHealthCheck {

    @Override
    public String getName() {
        return "BasicHealthCheck";
    }

    @Override
    protected Result check() throws Exception {
        return Result.healthy();
    }
}

