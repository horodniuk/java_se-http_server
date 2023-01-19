package some_tasks.postal_system.impl;

import some_tasks.postal_system.entity.MailMessage;
import some_tasks.postal_system.entity.Sendable;
import some_tasks.postal_system.service.MailService;

import java.util.logging.Level;
import java.util.logging.Logger;

import static some_tasks.postal_system.Main.AUSTIN_POWERS;

/*
    Spy is a spy who logs all email correspondence that passes through his hands.
    The object is constructed from a Logger instance, with which the spy will report all actions.
    It monitors only objects of the MailMessage class and writes the following messages to the logger
    (in expressions, you need to replace the parts in curly brackets with the values of the mail fields):

    1) If "Austin Powers" is specified as the sender or recipient,
    then you need to write a message to the log with the WARN level: Detected target mail correspondence:
     from {from} to {to} "{message}"

    2) Otherwise, it is necessary to write a message to the log with the INFO level:
     Usual correspondence: from {from} to {to}
 */
public class Spy implements MailService {
    private Logger logger;

    public Spy(Logger logger) {
        this.logger = logger;
    }

    @Override
    public Sendable processMail(Sendable mail) {
        if (mail instanceof MailMessage) {
            final MailMessage mailMessage = (MailMessage) mail;
            if (mail.getFrom().equals(AUSTIN_POWERS) || mail.getTo().equals(AUSTIN_POWERS)) {
                logger.log(Level.WARNING, "Detected target mail correspondence: from {0} to {1} \"{2}\"",
                        new Object[]{mail.getFrom(), mail.getTo(), mailMessage.getMessage()});
            } else {
                logger.log(Level.INFO, "Usual correspondence: from {0} to {1}",
                        new Object[]{mail.getFrom(), mail.getTo()});
            }
        }
        return mail;
    }
}
