package com.example.register.web;

import com.example.register.repository.*;
import com.example.register.service.RegistrationService;

public final class AppBootstrap {
    private static final UserRepository USER_REPOSITORY =
            new JdbcUserRepository("jdbc:h2:./data/registerdb;AUTO_SERVER=TRUE;DB_CLOSE_DELAY=-1");
    private static final RegistrationService REGISTRATION_SERVICE =
            new RegistrationService(USER_REPOSITORY);

    private AppBootstrap() {}
    public static RegistrationService registrationService() {
        return REGISTRATION_SERVICE;
    }
}