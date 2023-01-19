package some_tasks.postal_system.impl;

import some_tasks.postal_system.entity.MailPackage;
import some_tasks.postal_system.entity.Sendable;
import some_tasks.postal_system.service.MailService;

import static some_tasks.postal_system.Main.BANNED_SUBSTANCE;
import static some_tasks.postal_system.Main.WEAPONS;

/*
  An inspector who monitors prohibited and stolen parcels and
  sounds the alarm as an exception if such a parcel has been found.
  If it notices a prohibited package with one of the prohibited contents
  ("weapons" and "banned substance"), then it throws an IllegalPackageException.
  If it finds a package consisting of stones (contains the word "stones"),
  then the alarm will sound in the form of StolenPackageException.
  You must declare both exceptions yourself as unchecked exceptions.
 */
public class Inspector implements MailService {
    private String content;

    public Sendable processMail(Sendable mail) {
        if (mail instanceof MailPackage) {
            String content = ((MailPackage) mail).getContent().getContent();

            if (content.contains(WEAPONS) || content.contains(BANNED_SUBSTANCE)) {
                throw new IllegalPackageException();
            }
            else if (content.contains("stones")) {
                throw new StolenPackageException();
            }
        }
        return mail;
    }

    public static class IllegalPackageException extends RuntimeException {
    }

    public static class StolenPackageException extends RuntimeException {
    }
}
