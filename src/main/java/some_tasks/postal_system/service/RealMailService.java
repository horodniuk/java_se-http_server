package some_tasks.postal_system.service;

import some_tasks.postal_system.entity.Sendable;

/*
The class where the real mail logic is hidden
*/
public class RealMailService implements MailService {

    @Override
    public Sendable processMail(Sendable mail) {
        return mail;
    }
}
