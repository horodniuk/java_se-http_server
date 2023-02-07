package some_tasks.postal_system;

import some_tasks.postal_system.entity.MailPackage;
import some_tasks.postal_system.entity.Package;
import some_tasks.postal_system.impl.Inspector;
import some_tasks.postal_system.service.MailService;


public class Main {
    public static void main(String[] args) {
        MailService inspector = new Inspector();
        inspector.processMail(new MailPackage("from", "to", new Package("stones", 10)));
    }

    public static final String AUSTIN_POWERS = "Austin Powers";
    public static final String WEAPONS = "weapons";
    public static final String BANNED_SUBSTANCE = "banned substance";
}
