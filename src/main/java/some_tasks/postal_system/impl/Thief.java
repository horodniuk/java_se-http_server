package some_tasks.postal_system.impl;

import some_tasks.postal_system.entity.MailPackage;
import some_tasks.postal_system.entity.Package;
import some_tasks.postal_system.entity.Sendable;
import some_tasks.postal_system.service.MailService;

/*
   thief who steals the most valuable packages and ignores everything else.
   The thief accepts an int variable in the constructor - the minimum cost of the package that he will steal.
   Also, this class must contain the getStolenValue method,
   which returns the total cost of all the parcels that it stole.
   Theft occurs as follows: instead of the parcel that came to the thief, he gives a new one, the same,
    only with zero value and the contents of the parcel "stones instead of {content}".
 */
public class Thief implements MailService {
    private int minPrice = 0;
    private int stolenValue = 0;

    public Thief(int minPrice) {
        this.minPrice = minPrice;
    }

    public int getStolenValue() {
        return stolenValue;
    }

    @Override
    public Sendable processMail(Sendable mail) {
        MailPackage mailPackage = (MailPackage)mail;
        if (mail instanceof MailPackage && mailPackage.getContent().getPrice() >= minPrice) {
                stolenValue += mailPackage.getContent().getPrice();
                return new MailPackage(
                        mail.getFrom(),
                        mail.getTo(),
                        new Package("stones instead of " + mailPackage.getContent().getContent(), 0));
            }
        return mail;
    }
}
