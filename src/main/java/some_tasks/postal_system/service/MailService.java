package some_tasks.postal_system.service;

import some_tasks.postal_system.entity.Sendable;

/*
An interface that defines a class that can process a mail object in some way.
*/
public interface MailService {
    Sendable processMail(Sendable mail);
}
