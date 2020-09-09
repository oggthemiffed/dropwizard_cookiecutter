package {{cookiecutter.package}};

import io.dropwizard.Configuration;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import javax.validation.constraints.NotEmpty;

@Slf4j
@Getter
@Setter
public class ApplicationConfiguration extends Configuration {
    // TODO: implement service configuration
    @NotEmpty
    String testParameter;
}

